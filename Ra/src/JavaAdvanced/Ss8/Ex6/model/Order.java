package JavaAdvanced.Ss8.Ex6.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<Product> products;
    private List<Integer> quantities;
    private double subtotal;
    private double discount;
    private double total;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.subtotal = 0;
        this.discount = 0;
        this.total = 0;
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        subtotal += product.getPrice() * quantity;
    }

    public void applyDiscount(double discountAmount) {
        this.discount = discountAmount;
        this.total = subtotal - discount;
    }

    public String getOrderId() { return orderId; }
    public List<Product> getProducts() { return products; }
    public List<Integer> getQuantities() { return quantities; }
    public double getSubtotal() { return subtotal; }
    public double getDiscount() { return discount; }
    public double getTotal() { return total; }
    public String getCustomerName() { return customerName; }

    public void setCustomerEmail(String email) { this.customerEmail = email; }
    public void setCustomerPhone(String phone) { this.customerPhone = phone; }
    public String getCustomerEmail() { return customerEmail; }
    public String getCustomerPhone() { return customerPhone; }

    public void displayOrder() {
        System.out.println("\n=== CHI TIẾT ĐƠN HÀNG " + orderId + " ===");
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm:");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            int qty = quantities.get(i);
            System.out.printf("  - %s x%d = %,.0fđ%n", p.getName(), qty, p.getPrice() * qty);
        }
        System.out.printf("Tạm tính: %,.0fđ%n", subtotal);
        System.out.printf("Giảm giá: %,.0fđ%n", discount);
        System.out.printf("Tổng cộng: %,.0fđ%n", total);
        System.out.println("================================");
    }
}