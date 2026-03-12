package JavaAdvanced.Ss5.Mini1.fastfood.service;

import JavaAdvanced.Ss5.Mini1.fastfood.exception.InsufficientStockException;
import JavaAdvanced.Ss5.Mini1.fastfood.exception.InvalidDiscountException;
import JavaAdvanced.Ss5.Mini1.fastfood.exception.InvalidOrderIdException;

import JavaAdvanced.Ss5.Mini1.fastfood.model.Discount;
import JavaAdvanced.Ss5.Mini1.fastfood.model.MenuItem;
import JavaAdvanced.Ss5.Mini1.fastfood.model.Order;
import JavaAdvanced.Ss5.Mini1.fastfood.model.OrderItem;
import JavaAdvanced.Ss5.Mini1.fastfood.repository.DiscountRepository;
import JavaAdvanced.Ss5.Mini1.fastfood.repository.OrderRepository;

import java.time.LocalDate;

public class OrderService {

    private OrderRepository orderRepository;
    private DiscountRepository discountRepository;

    public OrderService(OrderRepository orderRepository,
                        DiscountRepository discountRepository) {

        this.orderRepository = orderRepository;
        this.discountRepository = discountRepository;
    }

    // Tạo đơn hàng
    public void createOrder(Order order) {

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (order.getOrderId() == null || order.getOrderId().trim().isEmpty()) {
            throw new IllegalArgumentException("Order id is required");
        }

        orderRepository.save(order);
    }

    // Thêm món vào đơn hàng
    public void addItem(String orderId, OrderItem item) {

        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order id is required");
        }

        if (item == null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }

        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new InvalidOrderIdException("Order not found"));

        MenuItem menuItem = item.getMenuItem();

        // Kiểm tra tồn kho
        if (menuItem.getStock() < item.getQuantity()) {
            throw new InsufficientStockException("Không đủ hàng trong kho");
        }

        // Trừ tồn kho
        menuItem.setStock(menuItem.getStock() - item.getQuantity());

        // Thêm món vào order
        order.addItem(menuItem, item.getQuantity());
    }

    // Áp dụng mã giảm giá
    public void applyDiscount(String orderId, String code) {

        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order id is required");
        }

        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Discount code is required");
        }

        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new InvalidOrderIdException("Order ID not found"));

        Discount discount = discountRepository.getDiscountByCode(code);

        if (discount == null) {
            throw new InvalidDiscountException("Discount code invalid");
        }

        // Kiểm tra hạn sử dụng
        if (discount.getExpiryDate().isBefore(LocalDate.now())) {
            throw new InvalidDiscountException("Discount expired");
        }

        if (discount.getPercentage() <= 0 || discount.getPercentage() > 100) {
            throw new InvalidDiscountException("Invalid discount percentage");
        }

        // Tính tiền giảm giá đúng
        double discountAmount =
                order.calculateTotal() * discount.getPercentage() / 100;

        order.setDiscountAmount(discountAmount);
        order.setDiscountCode(code);
    }

    // Tính tổng tiền đơn hàng
    public double calculateTotal(String orderId) {

        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order id is required");
        }

        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new InvalidOrderIdException("Order not found"));

        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Order has no items");
        }

        return order.getTotalAfterDiscount();
    }
}