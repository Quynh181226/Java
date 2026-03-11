package JavaAdvanced.Ss4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Kiểm thử độ mạnh của mật khẩu
// 1. Mục tiêu: Áp dụng nguyên tắc kiểm tra độc lập và tập trung vào hành vi (behavior).
// 2. Mô tả: Hệ thống đánh giá mật khẩu là "Mạnh" nếu có ít nhất 8 ký tự,
//            bao gồm cả chữ hoa, chữ thường, số và ký tự đặc biệt.
// Yêu cầu:
// - Viết phương thức evaluatePasswordStrength(String password).
// - Kiểm tra các kịch bản: mật khẩu thiếu chữ hoa, thiếu ký tự đặc biệt, quá ngắn.
// - Tránh kiểm tra chi tiết triển khai bên trong hàm, chỉ tập trung vào output trả về.
// - Sử dụng assertAll (nếu có thể) để kiểm tra nhiều điều kiện cùng lúc.
// 3. Test cases yêu cầu:
//    TC01: "Abc123!@"     → "Mạnh"
//    TC02: "abc123!@"     → "Trung bình" (thiếu chữ hoa)
//    TC03: "ABC123!@"     → "Trung bình" (thiếu chữ thường)
//    TC04: "Abcdef!@"     → "Trung bình" (thiếu số)
//    TC05: "Abc12345"     → "Trung bình" (thiếu ký tự đặc biệt)
//    TC06: "Ab1!"         → "Yếu" (quá ngắn)
//    TC07: "password"     → "Yếu" (chỉ chữ thường)
//    TC08: "ABC12345"     → "Yếu" (chỉ chữ hoa + số)
public class Ex4 {
    static class PasswordStrengthEvaluator {
        public String evaluatePasswordStrength(String password) {
            if (password == null || password.length() < 8) {
                return "Yếu";
            }

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                else if (Character.isLowerCase(c)) hasLower = true;
                else if (Character.isDigit(c)) hasDigit = true;
                else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
            }

            if (hasUpper && hasLower && hasDigit && hasSpecial) {
                return "Mạnh";
            } else if ((hasUpper || hasLower) && hasDigit && hasSpecial) {
                return "Trung bình";
            } else {
                return "Yếu";
            }
        }
    }

    @Test
    void TC01_mat_khau_day_du_tat_ca_yeu_to() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        String result = evaluator.evaluatePasswordStrength("Abc123!@");

        assertAll(
                () -> assertEquals("Mạnh", result, "Mật khẩu phải đạt mức Mạnh"),
                () -> assertNotEquals("Trung bình", result),
                () -> assertNotEquals("Yếu", result)
        );
    }

    @Test
    void TC02_mat_khau_thieu_chu_hoa() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Trung bình", evaluator.evaluatePasswordStrength("abc123!@"));
    }

    @Test
    void TC03_mat_khau_thieu_chu_thuong() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Trung bình", evaluator.evaluatePasswordStrength("ABC123!@"));
    }

    @Test
    void TC04_mat_khau_thieu_so() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Trung bình", evaluator.evaluatePasswordStrength("Abcdef!@"));
    }

    @Test
    void TC05_mat_khau_thieu_ky_tu_dac_biet() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Trung bình", evaluator.evaluatePasswordStrength("Abc12345"));
    }

    @Test
    void TC06_mat_khau_qua_ngan() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Yếu", evaluator.evaluatePasswordStrength("Ab1!"));
    }

    @Test
    void TC07_mat_khau_chi_co_chu_thuong() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Yếu", evaluator.evaluatePasswordStrength("password"));
    }

    @Test
    void TC08_mat_khau_chi_co_chu_hoa_va_so() {
        PasswordStrengthEvaluator evaluator = new PasswordStrengthEvaluator();
        assertEquals("Yếu", evaluator.evaluatePasswordStrength("ABC12345"));
    }
}