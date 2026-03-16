package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Kiểm thử định dạng Email và chuẩn hóa dữ liệu
// 1. Mục tiêu: Sử dụng @BeforeEach để thiết lập dữ liệu sạch và kiểm tra nhiều logic trong một class.
// 2. Mô tả: Phương thức xử lý email cần kiểm tra định dạng email hợp lệ và tự động chuyển email về dạng chữ thường (lowercase) trước khi lưu trữ.
// Yêu cầu:
// - Sử dụng @BeforeEach để khởi tạo đối tượng UserProcessor trước mỗi bài test.
// - Kiểm tra định dạng email (phải có ký tự '@' và tên miền).
// - Kiểm tra tính năng chuẩn hóa: Input "Example@Gmail.com" phải đầu ra là "example@gmail.com".
// - Tên phương thức test phải có ý nghĩa rõ ràng.
// 3. Test cases yêu cầu:
//    - "user@gmail.com"     → trả về "user@gmail.com"
//    - "usergmail.com"      → ném IllegalArgumentException (thiếu @)
//    - "user@"              → ném IllegalArgumentException (thiếu tên miền)
//    - "Example@Gmail.com"  → trả về "example@gmail.com" (chuẩn hóa lowercase)
public class Ex3 {
    static class UserProcessor {
        private UserProcessor() {}

        public String processEmail(String email) {
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email không được để trống hoặc null");
            }

            String trimmed = email.trim();
            if (!trimmed.contains("@")) {
                throw new IllegalArgumentException("Email phải chứa ký tự '@'");
            }

            String[] parts = trimmed.split("@", 2);
            if (parts.length != 2 || parts[1].trim().isEmpty()) {
                throw new IllegalArgumentException("Email phải có phần tên miền hợp lệ sau ký tự '@'");
            }

            // Chuẩn hóa: chuyển về lowercase
            return trimmed.toLowerCase();
        }
    }

    private UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void TC01_email_hop_le_va_giu_nguyen() {
        // Act
        String result = processor.processEmail("user@gmail.com");

        // Assert
        assertEquals("user@gmail.com", result);
    }

    @Test
    void TC02_email_thieu_ky_tu_at_thi_nem_ngoai_le() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("usergmail.com");
        });
    }

    @Test
    void TC03_email_co_at_nhung_thieu_ten_mien_thi_nem_ngoai_le() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("user@");
        });
    }

    @Test
    void TC04_email_chua_chu_hoa_phai_chuan_hoa_thanh_lowercase() {
        // Act
        String result = processor.processEmail("Example@Gmail.com");

        // Assert
        assertEquals("example@gmail.com", result);
    }
}