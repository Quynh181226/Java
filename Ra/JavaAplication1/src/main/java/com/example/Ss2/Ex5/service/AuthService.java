package com.example.Ss2.Ex5.service;

import com.example.Ss2.Ex5.model.User;
import org.springframework.stereotype.Service;

/**
 * AuthService (Ex05)
 *
 * Xu ly logic dang nhap (tach ra khoi Controller)
 */
@Service
public class AuthService {

    /**
     * Kiem tra dang nhap (hardcode)
     */
    public User authenticate(String username, String password) {
        if ("hr_manager".equals(username) && "hr123".equals(password)) {
            return new User("hr_manager", "Nguyen Thi Binh", "hr_manager");
        } else if ("hr_staff".equals(username) && "staff456".equals(password)) {
            return new User("hr_staff", "Tran Minh Khoa", "hr_staff");
        }
        return null;
    }
}