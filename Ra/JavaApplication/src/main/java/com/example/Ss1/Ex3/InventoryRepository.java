package com.example.Ss1.Ex3;

public interface InventoryRepository {
    int getStock(String Foodname);
    void updateStock(String Foodname, int quantity);
}




