package JavaAdvanced.Ss8.Ex6.strategy;

import JavaAdvanced.Ss8.Ex6.model.Order;

public interface DiscountStrategy {
    double calculateDiscount(Order order);
    String getDescription();
}