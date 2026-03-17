package JavaAdvanced.Ss8.Ex6.payment;

import JavaAdvanced.Ss8.Ex6.model.Order;

public interface PaymentMethod {
    boolean processPayment(Order order);
    String getDescription();
}