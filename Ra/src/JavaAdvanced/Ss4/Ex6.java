package JavaAdvanced.Ss4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// Kiểm thử cập nhật thông tin hồ sơ với ràng buộc
// 1. Mục tiêu: Đạt mức độ bao phủ code (Coverage) cao và thực hiện tài liệu sống thông qua Unit Test.
// 2. Mô tả: Khi cập nhật hồ sơ, người dùng không được phép:
//            - Thay đổi ngày sinh thành một ngày trong tương lai
//            - Thay đổi email trùng với email của người dùng khác đã tồn tại
// Yêu cầu:
// - Viết phương thức updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers)
// - Thiết kế test case bao phủ 100% các nhánh logic (if-else)
// - Sử dụng assertNull, assertNotNull để xác nhận trạng thái sau cập nhật
// - Code test phải dễ đọc, thể hiện rõ yêu cầu nghiệp vụ
public class Ex6 {
    static class User {
        private String email;
        private LocalDate birthDate;
        private String fullName; // ví dụ thông tin khác

        public User(String email, LocalDate birthDate, String fullName) {
            this.email = email;
            this.birthDate = birthDate;
            this.fullName = fullName;
        }

        public String getEmail() { return email; }
        public LocalDate getBirthDate() { return birthDate; }
        public String getFullName() { return fullName; }

        public void setEmail(String email) { this.email = email; }
        public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
        public void setFullName(String fullName) { this.fullName = fullName; }
    }

    static class UserProfile {
        private String email;
        private LocalDate birthDate;
        private String fullName;

        public UserProfile(String email, LocalDate birthDate, String fullName) {
            this.email = email;
            this.birthDate = birthDate;
            this.fullName = fullName;
        }

        public String getEmail() { return email; }
        public LocalDate getBirthDate() { return birthDate; }
        public String getFullName() { return fullName; }
    }

    static class ProfileService {
        /**
         * Cập nhật thông tin hồ sơ với các ràng buộc:
         * - Ngày sinh mới không được là ngày trong tương lai
         * - Email mới không được trùng với email của user khác (ngoại trừ chính user đang cập nhật)
         *
         * @return User đã cập nhật nếu thành công, null nếu vi phạm ràng buộc
         */
        public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {
            if (existingUser == null || newProfile == null) {
                return null;
            }

            LocalDate newBirthDate = newProfile.getBirthDate();
            if (newBirthDate != null && newBirthDate.isAfter(LocalDate.now())) {
                return null; // Ngày sinh trong tương lai → từ chối
            }

            String newEmail = newProfile.getEmail();
            if (newEmail != null && !newEmail.equals(existingUser.getEmail())) {
                // Kiểm tra trùng email với user khác
                for (User user : allUsers) {
                    if (user != existingUser && newEmail.equalsIgnoreCase(user.getEmail())) {
                        return null; // Trùng email → từ chối
                    }
                }
            }

            // Cập nhật thông tin
            if (newProfile.getEmail() != null) {
                existingUser.setEmail(newProfile.getEmail());
            }
            if (newProfile.getBirthDate() != null) {
                existingUser.setBirthDate(newProfile.getBirthDate());
            }
            if (newProfile.getFullName() != null) {
                existingUser.setFullName(newProfile.getFullName());
            }

            return existingUser;
        }
    }

    private ProfileService service;
    private User currentUser;
    private List<User> allUsers;

    @BeforeEach
    void setUp() {
        service = new ProfileService();
        allUsers = new ArrayList<>();

        currentUser = new User("quynh@example.com", LocalDate.of(2000, 5, 15), "Nguyễn Quỳnh");
        allUsers.add(currentUser);

        // Thêm một số user khác để kiểm tra trùng email
        allUsers.add(new User("admin@system.com", LocalDate.of(1995, 1, 1), "Admin"));
        allUsers.add(new User("otheruser@gmail.com", LocalDate.of(2002, 10, 20), "Người khác"));
    }

    @Test
    void TC01_cap_nhat_hop_le_email_va_ngay_sinh_moi() {
        UserProfile newProfile = new UserProfile("quynh.new@example.com", LocalDate.of(2001, 6, 10), "Quỳnh Updated");

        User updated = service.updateProfile(currentUser, newProfile, allUsers);

        assertNotNull(updated, "Hồ sơ phải được cập nhật thành công");
        assertEquals("quynh.new@example.com", updated.getEmail());
        assertEquals(LocalDate.of(2001, 6, 10), updated.getBirthDate());
        assertEquals("Quỳnh Updated", updated.getFullName());
    }

    @Test
    void TC02_ngay_sinh_trong_tuong_lai_phai_tu_choi() {
        UserProfile newProfile = new UserProfile("quynh@example.com", LocalDate.now().plusDays(10), null);

        User result = service.updateProfile(currentUser, newProfile, allUsers);

        assertNull(result, "Phải từ chối khi ngày sinh trong tương lai");
        // Kiểm tra không thay đổi dữ liệu cũ
        assertEquals(LocalDate.of(2000, 5, 15), currentUser.getBirthDate());
    }

    @Test
    void TC03_email_trung_voi_user_khac_phai_tu_choi() {
        UserProfile newProfile = new UserProfile("admin@system.com", null, null);

        User result = service.updateProfile(currentUser, newProfile, allUsers);

        assertNull(result, "Phải từ chối khi email trùng với user khác");
        assertEquals("quynh@example.com", currentUser.getEmail()); // không thay đổi
    }

    @Test
    void TC04_email_giong_email_hien_tai_van_cho_phep_cap_nhat_thong_tin_khac() {
        UserProfile newProfile = new UserProfile("quynh@example.com", null, "Quỳnh Nguyễn");

        User updated = service.updateProfile(currentUser, newProfile, allUsers);

        assertNotNull(updated, "Cho phép cập nhật khi email không thay đổi");
        assertEquals("Quỳnh Nguyễn", updated.getFullName());
        assertEquals("quynh@example.com", updated.getEmail()); // giữ nguyên
    }

    @Test
    void TC05_danh_sach_user_rong_van_cap_nhat_duoc() {
        List<User> emptyList = new ArrayList<>();
        UserProfile newProfile = new UserProfile("newemail@example.com", LocalDate.of(1999, 12, 1), null);

        User updated = service.updateProfile(currentUser, newProfile, emptyList);

        assertNotNull(updated, "Cho phép cập nhật khi không có user khác để so sánh email");
        assertEquals("newemail@example.com", updated.getEmail());
    }

    @Test
    void TC06_vi_pham_ca_hai_rang_buoc_ngay_sinh_va_email_trung() {
        UserProfile newProfile = new UserProfile("otheruser@gmail.com", LocalDate.now().plusYears(1), null);

        User result = service.updateProfile(currentUser, newProfile, allUsers);

        assertNull(result, "Phải từ chối khi vi phạm cả hai ràng buộc");
        // Dữ liệu cũ không thay đổi
        assertEquals("quynh@example.com", currentUser.getEmail());
        assertEquals(LocalDate.of(2000, 5, 15), currentUser.getBirthDate());
    }

    @Test
    void TC07_newProfile_null_phai_tu_choi() {
        User result = service.updateProfile(currentUser, null, allUsers);
        assertNull(result, "Phải từ chối khi newProfile là null");
    }
}