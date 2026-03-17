package JavaAdvanced.Ss8.Ex6.notification;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class SMSNotification implements NotificationService {
    private String smsGateway = "SMS Brandname";

    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("GỬI SMS THÔNG BÁO:");
        System.out.println("  - Đến SĐT: " + (order.getCustomerPhone() != null ?
                order.getCustomerPhone() : "*******"));
        System.out.println("  - Cổng: " + smsGateway);
        System.out.println("  - Nội dung: " + message);
        System.out.println("  - Đã gửi SMS thành công!");
    }

    @Override
    public String getDescription() {
        return "Thông báo qua SMS";
    }
}