package JavaAdvanced.Ss8.Ex6.factory;

import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.strategy.FirstTimeDiscount;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.payment.MomoPayment;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;
import JavaAdvanced.Ss8.Ex6.notification.PushNotification;

public class MobileAppFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod(String... params) {
        String phoneNumber = params.length > 0 ? params[0] : "0987654321";
        return new MomoPayment(phoneNumber);
    }

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }

    @Override
    public String getChannelName() {
        return "MOBILE APP";
    }
}