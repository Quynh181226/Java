package JavaAdvanced.Ss7;

import java.util.*;

/**
 * Bài tập Khá: ÁP DỤNG SRP - TÁCH LỚP ORDER PROCESSOR
 * * 1. Mục tiêu
 * - Hiểu và áp dụng Single Responsibility Principle (SRP).
 * - Nhận biết vi phạm SRP trong code hiện có.
 * - Thực hành tách một lớp có nhiều trách nhiệm thành các lớp riêng biệt.
 * * 2. Mô tả
 * * Bài toán:
 * Hệ thống hiện tại có một lớp OrderProcessor xử lý tất cả công việc:
 * tính tổng tiền, áp dụng giảm giá, xử lý thanh toán, lưu đơn hàng và gửi email.
 * Lớp này đang vi phạm SRP nghiêm trọng.
 * * Yêu cầu:
 * - Xác định các trách nhiệm mà lớp OrderProcessor đang đảm nhiệm.
 * - Tạo các lớp riêng biệt cho từng trách nhiệm:
 * + Lớp Order: chứa thông tin đơn hàng (mã đơn, khách hàng, danh sách sản phẩm, tổng tiền).
 * + Lớp Product: chứa thông tin sản phẩm (mã, tên, giá).
 * + Lớp Customer: chứa thông tin khách hàng (tên, email, địa chỉ).
 * + Lớp OrderCalculator: chịu trách nhiệm tính tổng tiền đơn hàng.
 * + Lớp OrderRepository: chịu trách nhiệm lưu và tìm kiếm đơn hàng.
 * + Lớp EmailService: chịu trách nhiệm gửi email xác nhận.
 * - Trong main, tạo một đơn hàng mới, sử dụng các lớp trên để xử lý và hiển thị kết quả.
 * * 3. Kết quả mong muốn
 * * Input:
 * - Tạo sản phẩm: SP01 - Laptop - 15000000, SP02 - Chuột - 300000
 * - Tạo khách hàng: Nguyễn Văn A - a@example.com
 * - Tạo đơn hàng: SP01 (1 cái), SP02 (2 cái)
 * * Output:
 * - Đã thêm sản phẩm SP01, SP02
 * - Đã thêm khách hàng
 * - Đơn hàng ORD001 được tạo
 * - Tính tổng tiền
 * - Tổng tiền: 15600000
 * - Lưu đơn hàng
 * - Đã lưu đơn hàng ORD001
 * - Gửi email xác nhận
 * - Đã gửi email đến a@example.com: Đơn hàng ORD001 đã được tạo
 */
class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items = new HashMap<>();

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, quantity);
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Map<Product, Integer> getItems() { return items; }
}

class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : order.getItems().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}

class OrderRepository {
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }
}

class EmailService {
    public void sendConfirmation(Order order) {
        System.out.println("Đã gửi email đến " + order.getCustomer().getEmail() + ": Đơn hàng " + order.getOrderId() + " đã được tạo");
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Product sp01 = new Product("SP01", "Laptop", 15000000);
        Product sp02 = new Product("SP02", "Chuột", 300000);
        System.out.println("Đã thêm sản phẩm " + sp01.getId() + ", " + sp02.getId());

        Customer customer = new Customer("Nguyễn Văn A", "a@example.com");
        System.out.println("Đã thêm khách hàng");

        Order order = new Order("ORD001", customer);
        order.addProduct(sp01, 1);
        order.addProduct(sp02, 2);
        System.out.println("Đơn hàng " + order.getOrderId() + " được tạo");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        System.out.println("Tổng tiền: " + (long)total);

        OrderRepository repository = new OrderRepository();
        repository.save(order);

        EmailService emailService = new EmailService();
        emailService.sendConfirmation(order);
    }
}