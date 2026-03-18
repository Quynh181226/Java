//package JavaAdvanced.Ss8.Ex6.singleton;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class OrderLogger {
//    private static OrderLogger instance;
//    private PrintWriter logWriter;
//    private DateTimeFormatter formatter;
//
//    private OrderLogger() {
//        try {
//            logWriter = new PrintWriter(new FileWriter("order_log.txt", true));
//            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            log("=== HỆ THỐNG BÁN HÀNG KHỞI ĐỘNG ===");
//        } catch (IOException e) {
//            System.err.println("Không thể tạo file log: " + e.getMessage());
//        }
//    }
//
//    public static synchronized OrderLogger getInstance() {
//        if (instance == null) {
//            instance = new OrderLogger();
//        }
//        return instance;
//    }
//
//    public void log(String message) {
//        String timestamp = LocalDateTime.now().format(formatter);
//        String logMessage = "[" + timestamp + "] " + message;
//        System.out.println("[LOG] " + message);
//        if (logWriter != null) {
//            logWriter.println(logMessage);
//            logWriter.flush();
//        }
//    }
//
//    public void logOrder(Order order, String channel) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("ĐƠN HÀNG ").append(order.getOrderId()).append(" | ");
//        sb.append("Kênh: ").append(channel).append(" | ");
//        sb.append("Khách: ").append(order.getCustomerName()).append(" | ");
//        sb.append("Tổng: ").append(String.format("%,.0f", order.getTotal())).append("đ");
//        log(sb.toString());
//    }
//
//    public void close() {
//        if (logWriter != null) {
//            log("=== HỆ THỐNG KẾT THÚC ===");
//            logWriter.close();
//        }
//    }
//}