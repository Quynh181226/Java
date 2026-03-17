package JavaAdvanced.Ss8.Ex6.payment;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class MomoPayment implements PaymentMethod {
    private String phoneNumber;
    private String momoAccount;

    public MomoPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.momoAccount = phoneNumber.substring(0, 3) + "****" +
                phoneNumber.substring(phoneNumber.length() - 3);
    }

    @Override
    public boolean processPayment(Order order) {
        System.out.println("XỬ LÝ THANH TOÁN MOMO:");
        System.out.println("  - Tài khoản: " + momoAccount);
        System.out.println("  - Số tiền: " + String.format("%,.0fđ", order.getTotal()));
        System.out.println("  - Quét mã QR hoặc nhập OTP để xác nhận");
        System.out.println("  - Thanh toán MoMo thành công!");
        return true;
    }

    @Override
    public String getDescription() {
        return "Thanh toán MoMo";
    }
}