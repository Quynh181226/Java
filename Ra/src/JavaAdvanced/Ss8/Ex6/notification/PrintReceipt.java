package JavaAdvanced.Ss8.Ex6.notification;

import JavaAdvanced.Ss8.Ex6.model.Order;

public class PrintReceipt implements NotificationService {
    private String printerName = "POS Printer 80mm";

    @Override
    public void sendNotification(Order order, String message) {
        System.out.println("IN HÓA ĐƠN TẠI QUẦY:");
        System.out.println("  - Máy in: " + printerName);
        System.out.println("  ===== HÓA ĐƠN BÁN HÀNG =====");
        System.out.println("  Mã đơn: " + order.getOrderId());
        System.out.println("  Ngày: " + java.time.LocalDate.now());
        System.out.println("  --------------------------");
        for (int i = 0; i < order.getProducts().size(); i++) {
            System.out.printf("  %s x%d%n", order.getProducts().get(i).getName(),
                    order.getQuantities().get(i));
        }
        System.out.println("  --------------------------");
        System.out.printf("  Tổng: %,.0fđ%n", order.getTotal());
        System.out.println("  ==========================");
        System.out.println("  Hóa đơn đã được in thành công!");
    }

    @Override
    public String getDescription() {
        return "In hóa đơn tại quầy";
    }
}