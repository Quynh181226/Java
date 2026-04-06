package com.example.Ss2.Ex3.model;



/**
 * User Model (Ex03)
 * Đại diện cho một nhân viên đăng nhập
 */
public class User {
    private String username;
    private String fullName;
    private String role;

    public User(String username, String fullName, String role) {
        this.username = username;
        this.fullName = fullName;
        this.role = role;
    }

    // ========== GETTERS ==========

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    // ========== TOSTRING ==========

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}