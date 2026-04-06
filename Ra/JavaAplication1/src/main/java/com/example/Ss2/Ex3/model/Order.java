package com.example.Ss2.Ex3.model;



import java.util.Date;

/**
 * Order Model (Ex03)
 * Đại diện cho một đơn hàng
 */
public class Order {
    private String orderCode;
    private String productName;
    private double totalAmount;
    private Date orderDate;

    public Order(String orderCode, String productName, double totalAmount, Date orderDate) {
        this.orderCode = orderCode;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // ========== GETTERS ==========

    public String getOrderCode() {
        return orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    // ========== TOSTRING ==========

    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", productName='" + productName + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}
