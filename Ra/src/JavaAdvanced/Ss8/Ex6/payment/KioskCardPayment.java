package JavaAdvanced.Ss8.Ex6.payment;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class KioskCardPayment implements PaymentMethod {
    private String cardNumber;
    private String bankName;

    public KioskCardPayment(String cardNumber, String bankName) {
        this.cardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        this.bankName = bankName;
    }

    @Override
    public boolean processPayment(Order order) {
        System.out.println("XỬ LÝ THANH TOÁN QUA KIOSK:");
        System.out.println("  - Ngân hàng: " + bankName);
        System.out.println("  - Thẻ: " + cardNumber);
        System.out.println("  - Số tiền: " + String.format("%,.0fđ", order.getTotal()));
        System.out.println("  - Vui lòng đưa thẻ vào đầu đọc tại Kiosk");
        System.out.println("  - Thanh toán thành công!");
        return true;
    }

    @Override
    public String getDescription() {
        return "Thanh toán thẻ tại Kiosk";
    }
}