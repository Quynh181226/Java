package com.example.Ss1.Ex3;

public interface UserAccountRepository {
    double getBalance(String username);
    void updateBalance(String username, double amount);
}
