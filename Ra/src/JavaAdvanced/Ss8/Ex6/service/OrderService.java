package JavaAdvanced.Ss8.Ex6.service;

import JavaAdvanced.Ss8.Ex6.factory.SalesChannelFactory;
import JavaAdvanced.Ss8.Ex6.model.Order;
import JavaAdvanced.Ss8.Ex6.model.Product;
import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;
import JavaAdvanced.Ss8.Ex6.singleton.OrderLogger;
import java.util.UUID;

public class OrderService {
    private SalesChannelFactory factory;
    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;
    private OrderLogger logger;

    public OrderService(SalesChannelFactory factory, String... paymentParams) {
        this.factory = factory;
        this.discountStrategy = factory.createDiscountStrategy();
        this.paymentMethod = factory.createPaymentMethod(paymentParams);
        this.notificationService = factory.createNotificationService();
        this.logger = OrderLogger.getInstance();

        logger.log("Khởi tạo OrderService cho kênh: " + factory.getChannelName());
    }

    public Order createOrder(String customerName) {
        String orderId = generateOrderId();
        Order order = new Order(orderId, customerName);
        logger.log("Tạo đơn hàng mới: " + orderId + " cho khách: " + customerName);
        return order;
    }

    public void addProduct(Order order, Product product, int quantity) {
        order.addProduct(product, quantity);
        logger.log("Thêm sản phẩm: " + product.getName() + " x" + quantity +
                " vào đơn " + order.getOrderId());
    }

    public void processOrder(Order order) {
        System.out.println("\n=== XỬ LÝ ĐƠN HÀNG - KÊNH " + factory.getChannelName() + " ===");

        // 1. Hiển thị thông tin đơn hàng
        order.displayOrder();

        // 2. Tính giảm giá
        double discount = discountStrategy.calculateDiscount(order);
        order.applyDiscount(discount);
        System.out.println("\nÁP DỤNG GIẢM GIÁ:");
        System.out.println("  - " + discountStrategy.getDescription());
        System.out.println("  - Số tiền giảm: " + String.format("%,.0fđ", discount));
        System.out.println("  - Thành tiền: " + String.format("%,.0fđ", order.getTotal()));

        // 3. Xử lý thanh toán
        System.out.println("\nXỬ LÝ THANH TOÁN:");
        boolean paymentSuccess = paymentMethod.processPayment(order);

        if (!paymentSuccess) {
            System.out.println("Thanh toán thất bại! Hủy đơn hàng.");
            logger.log("ĐƠN HÀNG " + order.getOrderId() + " - THANH TOÁN THẤT BẠI");
            return;
        }

        // 4. Gửi thông báo
        System.out.println("\nTHÔNG BÁO:");
        String message = "Đơn hàng " + order.getOrderId() + " đã được xác nhận. " +
                "Cảm ơn bạn đã mua sắm!";
        notificationService.sendNotification(order, message);

        // 5. Log đơn hàng
        logger.logOrder(order, factory.getChannelName());

        System.out.println("\n✅ ĐƠN HÀNG " + order.getOrderId() + " ĐÃ XỬ LÝ THÀNH CÔNG!");
    }

    private String generateOrderId() {
        return "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void setCustomerContact(Order order, String email, String phone) {
        order.setCustomerEmail(email);
        order.setCustomerPhone(phone);
    }
}