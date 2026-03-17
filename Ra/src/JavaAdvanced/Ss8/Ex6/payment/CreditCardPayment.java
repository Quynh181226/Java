package JavaAdvanced.Ss8.Ex6.payment;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolder = cardHolder;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        }
        return "****";
    }

    @Override
    public boolean processPayment(Order order) {
        System.out.println("XỬ LÝ THANH TOÁN THẺ TÍN DỤNG:");
        System.out.println("  - Thẻ: " + cardNumber);
        System.out.println("  - Chủ thẻ: " + cardHolder);
        System.out.println("  - Số tiền: " + String.format("%,.0fđ", order.getTotal()));
        System.out.println("  - Giao dịch thành công. Mã GD: " + generateTransactionId());
        return true;
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis() % 10000;
    }

    @Override
    public String getDescription() {
        return "Thanh toán thẻ tín dụng";
    }
}