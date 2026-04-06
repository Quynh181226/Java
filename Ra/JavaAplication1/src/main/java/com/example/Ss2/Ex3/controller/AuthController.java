package com.example.Ss2.Ex3.controller;

import com.example.Ss2.Ex3.model.User;        // ← SỬA import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * AuthController (Ex03)
 *
 * URL: /ex03/login (GET)
 *      /ex03/login (POST)
 *
 * Chuc nang:
 * 1. Hien thi trang dang nhap
 * 2. Xu ly dang nhap (kiem tra credential)
 * 3. Luu thong tin vao Session/Request Scope
 */
@Controller
@RequestMapping("/Ex3")
public class AuthController {

    /**
     * Hien thi trang dang nhap
     */
    @GetMapping("/login")
    public String loginPage() {
        return "Ex3/login";
    }

    /**
     * Xu ly dang nhap
     *
     * Scope explanation:
     * - errorMessage: REQUEST SCOPE (chi tồn tai trong 1 request)
     * - loggedUser: SESSION SCOPE (tồn tai xuyên suốt phiên dang nhap)
     */
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        boolean isValid = false;
        String fullName = "";
        String role = "";

        // Kiem tra credential (hardcode)
        if ("admin".equals(username) && "admin123".equals(password)) {
            isValid = true;
            fullName = "Nguyen Thi Binh";
            role = "Quan tri vien";
        } else if ("staff".equals(username) && "staff123".equals(password)) {
            isValid = true;
            fullName = "Tran Minh Khoa";
            role = "Nhan vien ban hang";
        }

        if (isValid) {
            // Dang nhap thanh cong
            // Luu vao SESSION SCOPE (tồn tai suốt phiên dang nhap)
            User loggedUser = new User(username, fullName, role);
            session.setAttribute("loggedUser", loggedUser);
            return "redirect:/Ex3/orders";
        } else {
            // Dang nhap that bai
            // Luu loi vao REQUEST SCOPE (chi tồn tai trong request nay)
            model.addAttribute("errorMessage", "Ten dang nhap hoac mat khau sai!");
            return "ex03/login";
        }
    }
}