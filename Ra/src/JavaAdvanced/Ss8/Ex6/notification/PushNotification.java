package JavaAdvanced.Ss8.Ex6.notification;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class PushNotification implements NotificationService {
    private String appName = "ShopApp";

    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("GỬI PUSH NOTIFICATION:");
        System.out.println("  - Ứng dụng: " + appName);
        System.out.println("  - Thiết bị: " + (order.getCustomerPhone() != null ?
                "Điện thoại " + order.getCustomerPhone().substring(0, 3) + "****" :
                "Điện thoại đã đăng ký"));
        System.out.println("  - Thông báo: " + message);
        System.out.println("  - Đã gửi notification thành công!");
    }

    @Override
    public String getDescription() {
        return "Push Notification";
    }
}