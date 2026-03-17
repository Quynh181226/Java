package JavaAdvanced.Ss8.Ex6.payment;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class CODPayment implements PaymentMethod {
    private String address;

    public CODPayment(String address) {
        this.address = address;
    }

    @Override
    public boolean processPayment(Order order) {
        System.out.println("XỬ LÝ THANH TOÁN COD (Thu hộ):");
        System.out.println("  - Địa chỉ giao hàng: " + address);
        System.out.println("  - Số tiền thu hộ: " + String.format("%,.0fđ", order.getTotal()));
        System.out.println("  - Đơn hàng sẽ được giao trong 2-3 ngày");
        System.out.println("  - Vui lòng chuẩn bị tiền mặt khi nhận hàng");
        return true;
    }

    @Override
    public String getDescription() {
        return "Thanh toán COD (tiền mặt)";
    }
}