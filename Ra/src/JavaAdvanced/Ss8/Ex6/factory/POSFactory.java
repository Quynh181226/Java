package JavaAdvanced.Ss8.Ex6.factory;

import JavaAdvanced.Ss8.Ex6.strategy.DiscountStrategy;
import JavaAdvanced.Ss8.Ex6.strategy.MemberDiscount;
import JavaAdvanced.Ss8.Ex6.payment.PaymentMethod;
import JavaAdvanced.Ss8.Ex6.payment.CODPayment;
import JavaAdvanced.Ss8.Ex6.notification.NotificationService;
import JavaAdvanced.Ss8.Ex6.notification.PrintReceipt;

public class POSFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod(String... params) {
        String address = params.length > 0 ? params[0] : "123 Đường ABC, Quận XYZ";
        return new CODPayment(address);
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }

    @Override
    public String getChannelName() {
        return "POS (CỬA HÀNG)";
    }
}