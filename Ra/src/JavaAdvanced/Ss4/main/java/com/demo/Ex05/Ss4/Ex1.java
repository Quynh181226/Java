package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Kiểm thử logic kiểm tra tên đăng nhập
// 1. Mục tiêu: Hiểu và áp dụng các câu lệnh khẳng định cơ bản (assertTrue, assertFalse)
// để kiểm tra logic nghiệp vụ đơn giản.
// 2. Mô tả: Hệ thống yêu cầu tên đăng nhập (username) phải có độ dài từ 6 đến 20 ký tự
// và không chứa khoảng trắng.
// Yêu cầu:
// - Viết lớp UserValidator với phương thức isValidUsername(String username).
// - Sử dụng JUnit 5 để viết các test case cho phương thức này.
// - Áp dụng quy trình Arrange - Act - Assert trong từng bài test.
// 3. Test cases yêu cầu:
// TC01: "user123"     → assertTrue
// TC02: "abc"         → assertFalse (quá ngắn)
// TC03: "user name"   → assertFalse (chứa khoảng trắng)
public class Ex1 {
    static class UserValidator {
        public boolean isValidUsername(String username) {
            if (username == null) {
                return false;
            }
            if (username.length() < 6 || username.length() > 20) {
                return false;
            }
            if (username.contains(" ")) {
                return false;
            }
            return true;
        }
    }

    @Test
    void TC01_username_hop_le() {
        // Arrange
        UserValidator validator = new UserValidator();
        String username = "user123";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    @Test
    void TC02_username_qua_ngan() {
        // Arrange
        UserValidator validator = new UserValidator();
        String username = "abc";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    @Test
    void TC03_username_chua_khoang_trang() {
        // Arrange
        UserValidator validator = new UserValidator();
        String username = "user name";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}