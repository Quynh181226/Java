//package SmartPhoneStore.src.view;
//
//import SmartPhoneStore.src.model.entity.Order;
//import SmartPhoneStore.src.model.entity.OrderDetail;
//import SmartPhoneStore.src.service.OrderService;
//import SmartPhoneStore.src.util.Console;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.List;
//
//public class OrderView {
//    private OrderService orderService;
//
//    public OrderView() {
//        this.orderService = new OrderService();
//    }
//
//    public void viewAllOrders() throws SQLException {
//        System.out.println("DANH SACH DON HANG");
//
//        List<Order> orders = orderService.getAllOrders();
//
//        if (orders.isEmpty()) {
//            Console.printInfo("Chua co don hang nao");
//        } else {
////            Console.printTableHeader("ID", "KHACH HANG", "NGAY DAT", "TONG TIEN", "TRANG THAI");
////            for (Order o : orders) {
////                Console.printTableRow(o.getId(),
////                        o.getUserFullName() != null ? o.getUserFullName() : "",
////                        o.getOrderDate(),
////                        o.getTotalAmount() + " VNĐ",
////                        getStatusText(o.getStatus()));
////            }
////            Console.printTableFooter();
//            System.out.println("┌────┬──────────────────────────────┬──────────────────────┬──────────────────────┬──────────────────────┐");
//            System.out.printf("│ %-4s │ %-28s │ %-20s │ %-20s │ %-20s │\n",
//                    "ID", "KHACH HANG", "NGAY DAT", "TONG TIEN", "TRANG THAI");
//            System.out.println("├────┼──────────────────────────────┼──────────────────────┼──────────────────────┼──────────────────────┤");
//
//            for (Order o : orders) {
//                System.out.printf("│ %-4s │ %-28s │ %-20s │ %-20s │ %-20s │\n",
//                        o.getId(),
//                        o.getUserFullName() != null ? o.getUserFullName() : "",
//                        o.getOrderDate(),
//                        o.getTotalAmount() + " VNĐ",
//                        getStatusText(o.getStatus()));
//            }
//
//            System.out.println("└────┴──────────────────────────────┴──────────────────────┴──────────────────────┴──────────────────────┘");
//        }
//    }
//
//    public void viewOrdersByStatus() throws SQLException {
////        ConsoleUtils.clearScreen();
//        System.out.println("DON HANG THEO TRANG THAI");
//
//        System.out.println("Cac trang thai: Pending, Shipping, Delivered, Cancelled");
//        String status = Console.inputString("Nhap trang thai: ");
//
//        List<Order> orders = orderService.getOrdersByStatus(status);
//
//        if (orders.isEmpty()) {
//            Console.printInfo("Khong co don hang nao voi trang thai " + status);
//        } else {
////            Console.printTableHeader("ID", "KHACH HANG", "NGAY DAT", "TONG TIEN", "TRANG THAI");
////            for (Order o : orders) {
////                Console.printTableRow(o.getId(),
////                        o.getUserFullName() != null ? o.getUserFullName() : "",
////                        o.getOrderDate(),
////                        o.getTotalAmount() + " VND",
////                        getStatusText(o.getStatus()));
////            }
////            Console.printTableFooter();
//            System.out.println("┌────┬──────────────────────────────┬──────────────────────┬──────────────────────┬──────────────────────┐");
//            System.out.printf("│ %-4s │ %-28s │ %-20s │ %-20s │ %-20s │\n",
//                    "ID", "KHACH HANG", "NGAY DAT", "TONG TIEN", "TRANG THAI");
//            System.out.println("├────┼──────────────────────────────┼──────────────────────┼──────────────────────┼──────────────────────┤");
//
//            for (Order o : orders) {
//                System.out.printf("│ %-4s │ %-28s │ %-20s │ %-20s │ %-20s │\n",
//                        o.getId(),
//                        o.getUserFullName() != null ? o.getUserFullName() : "",
//                        o.getOrderDate(),
//                        o.getTotalAmount() + " VNĐ",
//                        getStatusText(o.getStatus()));
//            }
//
//            System.out.println("└────┴──────────────────────────────┴──────────────────────┴──────────────────────┴──────────────────────┘");
//        }
//    }
//
//    public void updateOrderStatus() throws SQLException {
//        System.out.println("CAP NHAT TRANG THAI DON HANG");
//
//        viewAllOrders();
//        System.out.println();
//
//        int orderId = Console.inputInt("Nhap ID don hang: ");
//        Order order = orderService.getOrderById(orderId);
//
//        if (order == null) {
//            Console.printError("Khong tim thay don hang");
//            return;
//        }
//
//        System.out.println();
//        Console.printInfo("Trang thai hien tai: " + getStatusText(order.getStatus()));
//        System.out.println("Cac trang thai co the: Pending, Shipping, Delivered, Cancelled");
//        String newStatus = Console.inputString("Nhap trang thai moi: ");
//
//        if (orderService.updateOrderStatus(orderId, newStatus)) {
//            Console.printSuccess("Cap nhat trang thai don hang thanh cong");
//        } else {
//            Console.printError("Cap nhat that bai");
//        }
//    }
//
//    public void viewOrderDetail() throws SQLException {
////        ConsoleUtils.clearScreen();
//        System.out.println("CHI TIET DON HANG");
//
//        viewAllOrders();
//        System.out.println();
//
//        int orderId = Console.inputInt("Nhap ID don hang: ");
//        Order order = orderService.getOrderById(orderId);
//
//        if (order == null) {
//            Console.printError("Khong tim thay don hang");
//            return;
//        }
//
//        System.out.println("CHI TIET DON HANG #" + orderId);
//
//        Console.printSeparator();
//        System.out.println("Khach hang: " + (order.getUserFullName() != null ? order.getUserFullName() : ""));
//        System.out.println("Ngay dat: " + order.getOrderDate());
//        System.out.println("Dia chi giao: " + order.getShippingAddress());
//        System.out.println("So dien thoai: " + order.getShippingPhone());
//        System.out.println("Trang thai: " + getStatusText(order.getStatus()));
//        System.out.println("Tong tien: " + order.getTotalAmount() + " VND");
//        if (order.getCouponCode() != null) {
//            System.out.println("Ma giam gia: " + order.getCouponCode());
//            System.out.println("Giam gia: " + order.getDiscountAmount() + " VND");
//        }
//        Console.printSeparator();
//
//        List<OrderDetail> details = orderService.getOrderDetails(orderId);
//
//        if (details.isEmpty()) {
//            Console.printInfo("Khong co san pham nao trong don hang");
//        } else {
//            System.out.println();
////            Console.printTableHeader("SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
////            for (OrderDetail d : details) {
////                BigDecimal subtotal = d.getPrice().multiply(BigDecimal.valueOf(d.getQuantity()));
////                Console.printTableRow(
////                        d.getProductName() != null ? d.getProductName() : "",
////                        d.getQuantity(),
////                        d.getPrice() + " VND",
////                        subtotal + " VND");
////            }
////            Console.printTableFooter();
//            System.out.println("┌──────────────────────────────┬──────────────┬──────────────────────┬──────────────────────┐");
//            System.out.printf("│ %-28s │ %-12s │ %-20s │ %-20s │\n",
//                    "SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
//            System.out.println("├──────────────────────────────┼──────────────┼──────────────────────┼──────────────────────┤");
//
//            for (OrderDetail d : details) {
//                BigDecimal subtotal = d.getPrice().multiply(BigDecimal.valueOf(d.getQuantity()));
//                System.out.printf("│ %-28s │ %-12d │ %-20s │ %-20s │\n",
//                        d.getProductName() != null ? d.getProductName() : "",
//                        d.getQuantity(),
//                        d.getPrice() + " VND",
//                        subtotal + " VND");
//            }
//
//            System.out.println("└──────────────────────────────┴──────────────┴──────────────────────┴──────────────────────┘");
//        }
//    }
//
//    private String getStatusText(String status) {
//        if (status == null) return "";
//        switch (status.toLowerCase()) {
//            case "pending": return "Chờ xử lý";
//            case "shipping": return "Đang giao";
//            case "delivered": return "Đã giao";
//            case "cancelled": return "Đã hủy";
//            default: return status;
//        }
//    }
//}