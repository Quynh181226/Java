package JavaAdvanced.Ss8.Ex6.notification;

import JavaAdvanced.Ss8.Ex6.model.Order;

public interface NotificationService {
    void sendNotification(Order order, String message);
    String getDescription();
}