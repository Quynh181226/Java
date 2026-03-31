package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.UserDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.UserDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.BCrypt;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Validator;
import java.sql.SQLException;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAOImpl();
    }

    public User login(String email, String password) throws SQLException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email khong duoc de trong");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Mat khau khong duoc de trong");
        }

        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Email hoac mat khau khong dung");
        }

        if (!user.isActive()) {
            throw new IllegalArgumentException("Tai khoan da bi khoa");
        }

        if (!BCrypt.checkPassword(password, user.getPassword())) {
            throw new IllegalArgumentException("Email hoac mat khau khong dung");
        }

        return user;
    }

    public boolean register(String fullName, String email, String password, String confirmPassword, String phone, String address) throws SQLException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ho ten khong duoc de trong");
        }
        if (!Validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Email khong dung dinh dang");
        }
        if (userDAO.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email da duoc dang ky");
        }
        if (!Validator.isStrongPassword(password)) {
            throw new IllegalArgumentException("Mat khau phai co it nhat 6 ky tu");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Mat khau xac nhan khong khop");
        }
        if (!Validator.isValidPhone(phone)) {
            throw new IllegalArgumentException("So dien thoai khong dung dinh dang");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Dia chi khong duoc de trong");
        }

        String hashedPassword = BCrypt.hashPassword(password);
        User user = new User(fullName, email, hashedPassword, phone, address);
        return userDAO.save(user);
    }

    //public boolean checkUserExists(String email, String phone) throws SQLException {
    //    User user = userDAO.findByEmail(email);
    //    if (user == null) {
    //        return false;
    //    }
    //    return user.getPhone().equals(phone);
    //}

    public boolean checkUserExists(String email) throws SQLException {
        return userDAO.findByEmail(email) != null;
    }

    public boolean updatePassword(String email, String newPassword) throws SQLException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            return false;
        }

        if (!Validator.isStrongPassword(newPassword)) {
            throw new IllegalArgumentException("Mat khau phai co it nhat 6 ky tu");
        }

        user.setPassword(BCrypt.hashPassword(newPassword));
        return userDAO.update(user);
    }

    public boolean changePassword(int userId, String oldPassword, String newPassword) throws SQLException {
        User user = userDAO.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Khong tim thay nguoi dung");
        }

        if (!BCrypt.checkPassword(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Mat khau cu khong dung");
        }

        if (!Validator.isStrongPassword(newPassword)) {
            throw new IllegalArgumentException("Mat khau moi phai co it nhat 6 ky tu");
        }

        user.setPassword(BCrypt.hashPassword(newPassword));
        return userDAO.update(user);
    }

    public boolean updateProfile(int userId, String fullName, String phone, String address) throws SQLException {
        User user = userDAO.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Khong tim thay nguoi dung");
        }

        if (fullName != null && !fullName.trim().isEmpty()) {
            user.setFullName(fullName);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            if (!Validator.isValidPhone(phone)) {
                throw new IllegalArgumentException("So dien thoai khong dung dinh dang");
            }
            user.setPhone(phone);
        }
        if (address != null && !address.trim().isEmpty()) {
            user.setAddress(address);
        }

        return userDAO.update(user);
    }
}