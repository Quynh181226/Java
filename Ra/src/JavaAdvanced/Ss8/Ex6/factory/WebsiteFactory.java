package JavaAdvanced.Ss8.Ex6.factory;

import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.strategy.WebsiteDiscount;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.payment.CreditCardPayment;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;
import JavaAdvanced.Ss8.Ex6.notification.EmailNotification;

public class WebsiteFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod(String... params) {
        String cardNumber = params.length > 0 ? params[0] : "1234567890123456";
        String cardHolder = params.length > 1 ? params[1] : "Nguyen Van A";
        return new CreditCardPayment(cardNumber, cardHolder);
    }

    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }

    @Override
    public String getChannelName() {
        return "WEBSITE";
    }
}