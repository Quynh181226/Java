package JavaAdvanced.Ss8.Ex6.strategy;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class KioskDiscount implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.07; // 7%

    @Override
    public double calculateDiscount(Order order) {
        double discount = order.getSubtotal() * DISCOUNT_RATE;
        return Math.round(discount * 100) / 100.0;
    }

    @Override
    public String getDescription() {
        return "Giảm giá Kiosk 7%";
    }
}