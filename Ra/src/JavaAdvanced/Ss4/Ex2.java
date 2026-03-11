package JavaAdvanced.Ss4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Kiểm thử điều kiện tuổi đăng ký
// 1. Mục tiêu: Thực hành kiểm tra giá trị biên và xử lý ngoại lệ với assertEquals và assertThrows.
// 2. Mô tả: Người dùng chỉ được phép đăng ký tài khoản nếu từ 18 tuổi trở lên.
//            Nếu tuổi nhập vào là số âm, hệ thống phải ném ra IllegalArgumentException.
// Yêu cầu:
// - Viết phương thức checkRegistrationAge(int age) trong lớp UserService.
// - Sử dụng @Test để khai báo các phương thức kiểm thử.
// - Đảm bảo mỗi test case chỉ kiểm tra một nhiệm vụ duy nhất.
// 3. Test cases yêu cầu:
//    - Tuổi 18   → true
//    - Tuổi 17   → false
//    - Tuổi -1   → ném IllegalArgumentException
public class Ex2 {
    static class UserService {
        public boolean checkRegistrationAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Tuổi không được âm");
            }
            return age >= 18;
        }
    }

    @Test
    void TC01_tuoi_du_18_hop_le() {
        // Arrange
        UserService service = new UserService();
        int age = 18;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void TC02_tuoi_nho_hon_18_khong_hop_le() {
        // Arrange
        UserService service = new UserService();
        int age = 17;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void TC03_tuoi_am_phai_nem_ngoai_le() {
        // Arrange
        UserService service = new UserService();
        int age = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}