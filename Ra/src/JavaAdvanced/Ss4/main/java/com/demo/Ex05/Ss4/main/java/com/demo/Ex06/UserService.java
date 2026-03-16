package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.main.java.com.demo.Ex06;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {

        // Kiểm tra ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        // Kiểm tra email trùng với user khác
        if (allUsers != null) {
            for (User user : allUsers) {
                if (!user.equals(existingUser) &&
                        user.getEmail().equalsIgnoreCase(newProfile.getEmail())) {
                    return null;
                }
            }
        }

        // Cập nhật thông tin
        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}