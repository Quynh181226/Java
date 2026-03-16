package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// [TỔNG HỢP] XÂY DỰNG UNIT TEST CHO HỆ THỐNG QUẢN LÝ NGƯỜI DÙNG (USER MANAGEMENT)
// 1) Mục tiêu:
// - Áp dụng thành thạo quy trình 4 bước: Arrange - Act - Assert - Verify.
// - Sử dụng các Annotation cơ bản của JUnit 5 như @Test và @BeforeEach.
// - Thực hành các câu lệnh khẳng định: assertEquals, assertTrue, assertNull, và assertThrows.

// 2) Mô tả & Yêu cầu:
// - Tạo lớp User: id (int), username (String), email (String).
// - Tạo lớp UserService chứa List<User> và các phương thức:
//   + addUser(User user): Thêm user. Nếu username null/rỗng -> ném IllegalArgumentException.
//   + findUserById(int id): Trả về User nếu tìm thấy, ngược lại trả về null.
//   + isValidEmail(String email): Trả về true nếu email chứa "@" và không để trống.

// 3) Viết Unit Test (Lớp UserServiceTest):
// - Sử dụng @BeforeEach để khởi tạo UserService và làm sạch dữ liệu trước mỗi bài test.
// - Viết ít nhất 4 test case:
//   + TC 1: Kiểm tra thêm người dùng thành công (assertEquals kiểm tra size).
//   + TC 2: Kiểm tra ném ngoại lệ khi username là null (assertThrows).
//   + TC 3: Kiểm tra tìm kiếm người dùng không tồn tại (assertNull).
//   + TC 4: Kiểm tra định dạng email hợp lệ (assertTrue).

// 4) Nguyên tắc thực hiện:
// - Đặt tên phương thức rõ ràng (Ví dụ: shouldReturnTrueWhenEmailIsValid()).
// - Tuân thủ mô hình Arrange - Act - Assert trong từng phương thức test.
// - Kết quả mong muốn: Toàn bộ test case đều "Xanh" (Pass).
public class Btth {
    // Lớp User
    static class User {
        private int id;
        private String username;
        private String email;

        public User(int id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }
    }

    // Lớp UserService (chứa logic nghiệp vụ)
    static class UserService {
        private final List<User> users = new ArrayList<>();

        public void addUser(User user) {
            if (user == null) {
                throw new IllegalArgumentException("User không được null");
            }
            if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
                throw new IllegalArgumentException("Username không được null hoặc rỗng");
            }
            users.add(user);
        }

        public User findUserById(int id) {
            for (User user : users) {
                if (user.getId() == id) {
                    return user;
                }
            }
            return null;
        }

        public boolean isValidEmail(String email) {
            if (email == null || email.trim().isEmpty()) {
                return false;
            }
            return email.contains("@");
        }

        // Phương thức hỗ trợ cho test (không bắt buộc trong đề, nhưng giúp test dễ hơn)
        public int getUserCount() {
            return users.size();
        }

        public void clear() {
            users.clear();
        }
    }

    // Lớp Test
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        // Đảm bảo danh sách sạch trước mỗi test
        userService.clear();
    }

    @Test
    void shouldAddUserSuccessfullyAndIncreaseListSize() {
        // Arrange
        User newUser = new User(1, "nguyenquynh", "quynh@example.com");

        // Act
        userService.addUser(newUser);

        // Assert
        assertEquals(1, userService.getUserCount(), "Danh sách phải có 1 người dùng sau khi thêm");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAddingUserWithNullUsername() {
        // Arrange
        User invalidUser = new User(2, null, "test@example.com");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.addUser(invalidUser),
                "Phải ném ngoại lệ khi username là null"
        );

        assertTrue(exception.getMessage().contains("Username không được null hoặc rỗng"),
                "Thông báo ngoại lệ phải đúng nội dung");
    }

    @Test
    void shouldReturnNullWhenSearchingForNonExistentUser() {
        // Arrange - danh sách đang rỗng (do @BeforeEach)

        // Act
        User foundUser = userService.findUserById(999);

        // Assert
        assertNull(foundUser, "Không tìm thấy user nên phải trả về null");
    }

    @Test
    void shouldReturnTrueWhenEmailIsValid() {
        // Arrange
        String validEmail = "quynh.nguyen@gmail.com";

        // Act
        boolean isValid = userService.isValidEmail(validEmail);

        // Assert
        assertTrue(isValid, "Email hợp lệ (có @) phải trả về true");
    }
}