package JavaAdvanced.Ss8.Ex6.factory;

import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;

public interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod(String... params);
    NotificationService createNotificationService();
    String getChannelName();
}