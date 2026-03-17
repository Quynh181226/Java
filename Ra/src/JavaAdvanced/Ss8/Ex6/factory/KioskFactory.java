package JavaAdvanced.Ss8.Ex6.factory;

import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.strategy.KioskDiscount;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.payment.KioskCardPayment;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;
import JavaAdvanced.Ss8.Ex6.notification.SMSNotification;

public class KioskFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod(String... params) {
        String cardNumber = params.length > 0 ? params[0] : "9876543210123456";
        String bankName = params.length > 1 ? params[1] : "Vietcombank";
        return new KioskCardPayment(cardNumber, bankName);
    }

    @Override
    public NotificationService createNotificationService() {
        return new SMSNotification();
    }

    @Override
    public String getChannelName() {
        return "KIOSK TỰ ĐỘNG";
    }
}