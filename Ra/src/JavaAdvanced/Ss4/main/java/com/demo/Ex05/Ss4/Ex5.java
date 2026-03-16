package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Kiểm thử phân quyền người dùng (Role-based Access)
// 1. Mục tiêu: Thực hành kiểm thử logic phức tạp và đảm bảo tính độc lập giữa các thành phần.
// 2. Mô tả: Hệ thống có 3 vai trò: ADMIN, MODERATOR, và USER.
//            ADMIN có quyền xóa người dùng, MODERATOR chỉ có quyền khóa người dùng,
//            USER chỉ có quyền xem thông tin cá nhân.
// Yêu cầu:
// - Xây dựng phương thức canPerformAction(User user, Action action).
// - Áp dụng nguyên tắc Top-Down: Viết test cho logic chính của ADMIN trước,
//   sau đó đến các vai trò thấp hơn.
// - Đảm bảo các test case không phụ thuộc vào database thực tế (giả lập đối tượng User).
// - Sử dụng @AfterEach để dọn dẹp các đối tượng giả sau mỗi bài test (nếu cần).
// 3. Ma trận phân quyền cần kiểm chứng:
//    ADMIN  → DELETE_USER: true, LOCK_USER: true,  VIEW_PROFILE: true
//    MODERATOR → DELETE_USER: false, LOCK_USER: true, VIEW_PROFILE: true
//    USER   → DELETE_USER: false, LOCK_USER: false, VIEW_PROFILE: true
public class Ex5 {
    enum Role {
        ADMIN, MODERATOR, USER
    }

    enum Action {
        DELETE_USER, LOCK_USER, VIEW_PROFILE
    }

    static class User {
        private final Role role;

        public User(Role role) {
            this.role = role;
        }

        public Role getRole() {
            return role;
        }
    }

    static class AccessController {
        public boolean canPerformAction(User user, Action action) {
            if (user == null || user.getRole() == null) {
                return false;
            }

            Role role = user.getRole();

            switch (action) {
                case VIEW_PROFILE:
                    return true; // Tất cả vai trò đều được xem profile

                case LOCK_USER:
                    return role == Role.ADMIN || role == Role.MODERATOR;

                case DELETE_USER:
                    return role == Role.ADMIN;

                default:
                    return false;
            }
        }
    }

    private AccessController controller;
    private User admin;
    private User moderator;
    private User regularUser;

    @BeforeEach
    void setUp() {
        controller = new AccessController();
        admin = new User(Role.ADMIN);
        moderator = new User(Role.MODERATOR);
        regularUser = new User(Role.USER);
    }

    @AfterEach
    void tearDown() {
        // Dọn dẹp tham chiếu (dù Java GC sẽ tự xử lý, nhưng để minh họa)
        admin = null;
        moderator = null;
        regularUser = null;
        controller = null;
    }

    // ── Test theo nguyên tắc Top-Down: ADMIN trước ──

    @Test
    void TC01_admin_co_the_xoa_nguoi_dung() {
        assertTrue(controller.canPerformAction(admin, Action.DELETE_USER),
                "ADMIN phải có quyền DELETE_USER");
    }

    @Test
    void TC02_admin_co_the_khoa_nguoi_dung() {
        assertTrue(controller.canPerformAction(admin, Action.LOCK_USER),
                "ADMIN phải có quyền LOCK_USER");
    }

    @Test
    void TC03_admin_co_the_xem_thong_tin() {
        assertTrue(controller.canPerformAction(admin, Action.VIEW_PROFILE),
                "ADMIN phải có quyền VIEW_PROFILE");
    }

    // ── Tiếp theo: MODERATOR ──

    @Test
    void TC04_moderator_khong_duoc_xoa_nguoi_dung() {
        assertFalse(controller.canPerformAction(moderator, Action.DELETE_USER),
                "MODERATOR không được phép DELETE_USER");
    }

    @Test
    void TC05_moderator_co_the_khoa_nguoi_dung() {
        assertTrue(controller.canPerformAction(moderator, Action.LOCK_USER),
                "MODERATOR phải có quyền LOCK_USER");
    }

    @Test
    void TC06_moderator_co_the_xem_thong_tin() {
        assertTrue(controller.canPerformAction(moderator, Action.VIEW_PROFILE),
                "MODERATOR phải có quyền VIEW_PROFILE");
    }

    // ── Cuối cùng: USER thường ──

    @Test
    void TC07_user_thuong_khong_duoc_xoa_nguoi_dung() {
        assertFalse(controller.canPerformAction(regularUser, Action.DELETE_USER),
                "USER không được phép DELETE_USER");
    }

    @Test
    void TC08_user_thuong_khong_duoc_khoa_nguoi_dung() {
        assertFalse(controller.canPerformAction(regularUser, Action.LOCK_USER),
                "USER không được phép LOCK_USER");
    }

    @Test
    void TC09_user_thuong_duoc_xem_thong_tin_ca_nhan() {
        assertTrue(controller.canPerformAction(regularUser, Action.VIEW_PROFILE),
                "USER phải có quyền VIEW_PROFILE");
    }

    // ── Test bổ sung kiểm tra an toàn ──

    @Test
    void TC10_user_null_khong_duoc_phep_thuc_hien_bat_ky_hanh_dong_nao() {
        assertFalse(controller.canPerformAction(null, Action.VIEW_PROFILE));
        assertFalse(controller.canPerformAction(null, Action.LOCK_USER));
        assertFalse(controller.canPerformAction(null, Action.DELETE_USER));
    }
}