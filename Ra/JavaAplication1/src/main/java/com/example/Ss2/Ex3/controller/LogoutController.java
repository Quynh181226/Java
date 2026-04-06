package com.example.Ss2.Ex3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * LogoutController (Ex03)
 *
 * URL: /ex03/logout
 *
 * Chuc nang: Dang xuat (invalidate session)
 */
@Controller
@RequestMapping("/Ex3")
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate session (xoa tat ca du lieu session)
        session.invalidate();
        return "redirect:/Ex3/login";
    }
}