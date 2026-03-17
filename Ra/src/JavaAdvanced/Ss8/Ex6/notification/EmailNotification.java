package JavaAdvanced.Ss8.Ex6.notification;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class EmailNotification implements NotificationService {
    private String emailServer = "smtp.gmail.com";

    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("GỬI EMAIL XÁC NHẬN:");
        System.out.println("  - Đến: " + (order.getCustomerEmail() != null ?
                order.getCustomerEmail() : "khachhang@email.com"));
        System.out.println("  - Tiêu đề: Xác nhận đơn hàng " + order.getOrderId());
        System.out.println("  - Nội dung: " + message);
        System.out.println("  - Email đã được gửi thành công!");
    }

    @Override
    public String getDescription() {
        return "Thông báo qua Email";
    }
}