//package SmartPhoneStore.src.view;
//
//import SmartPhoneStore.src.service.ReportService;
//import SmartPhoneStore.src.util.Console;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.Map;
//
//public class ReportView {
//    private ReportService reportService;
//
//    public ReportView() {
//        this.reportService = new ReportService();
//    }
//
//    public void showTotalRevenue() throws SQLException {
//        System.out.println("TONG DOANH THU");
//
//        BigDecimal revenue = reportService.getTotalRevenue();
//
//        Console.printBox("Tong doanh thu tu cac don hang da giao: " + revenue + " VND");
//    }
//
//    public void showRevenueByMonth() throws SQLException {
//        System.out.println("- - - - Doanh thu theo tháng:");
//
//
//        int month = Console.inputInt("Nhap thang (1-12): ");
//        int year = Console.inputInt("Nhap nam: ");
//
//        BigDecimal revenue = reportService.getRevenueByMonth(month, year);
//
//        Console.printBox("Doanh thu thang " + month + "/" + year + ": " + revenue + " VND");
//    }
//
//    public void showTopProducts() throws SQLException {
//        System.out.println("- - - - Top 5 sản phẩm bán chạy nhất :");
//
//
//        Map<String, Integer> topProducts = reportService.getTopSellingProducts(5);
//
//        if (topProducts.isEmpty()) {
//            Console.printInfo("Chua co du lieu thong ke");
//        } else {
////            Console.printTableHeader("STT", "SAN PHAM", "SO LUONG DA BAN");
////            int stt = 1;
////            for (Map.Entry<String, Integer> entry : topProducts.entrySet()) {
////                Console.printTableRow(stt++, entry.getKey(), entry.getValue());
////            }
////            Console.printTableFooter();
//            System.out.println("┌────┬──────────────────────────────┬──────────────┐");
//            System.out.printf("│ %-4s │ %-28s │ %-12s │\n",
//                    "STT", "SAN PHAM", "SO LUONG DA BAN");
//            System.out.println("├────┼──────────────────────────────┼──────────────┤");
//
//            int stt = 1;
//            for (Map.Entry<String, Integer> entry : topProducts.entrySet()) {
//                System.out.printf("│ %-4d │ %-28s │ %-12d │\n",
//                        stt++, entry.getKey(), entry.getValue());
//            }
//
//            System.out.println("└────┴──────────────────────────────┴──────────────┘");
//        }
//    }
//
//    public void showOrderStatistics() throws SQLException {
//        System.out.println("- - - - Thống kê đơn hàng theo trạng thái :");
//        Map<String, Integer> stats = reportService.getOrderStatistics();
//
////        Console.printTableHeader("TRANG THAI", "SO LUONG");
////        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
////            String statusText = getStatusText(entry.getKey());
////            Console.printTableRow(statusText, entry.getValue());
////        }
////        Console.printTableFooter();
//        System.out.println("┌──────────────────────┬──────────────┐");
//        System.out.printf("│ %-20s │ %-12s │\n",
//                "TRANG THAI", "SO LUONG");
//        System.out.println("├──────────────────────┼──────────────┤");
//
//        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
//            String statusText = getStatusText(entry.getKey());
//            System.out.printf("│ %-20s │ %-12d │\n",
//                    statusText, entry.getValue());
//        }
//
//        System.out.println("└──────────────────────┴──────────────┘");
//    }
//
//    public void showFullReport() throws SQLException {
//        while (true) {
//            System.out.println("- - - - Thống kê & Báo cáo :");
//
//            System.out.println("1. Tong doanh thu");
//            System.out.println("2. Doanh thu theo thang");
//            System.out.println("3. Top 5 san pham ban chay");
//            System.out.println("4. Thong ke don hang theo trang thai");
//            System.out.println("0. Quay lai");
//
//            int choice = Console.inputInt("Lua chon: ");
//
//            switch (choice) {
//                case 1:
//                    showTotalRevenue();
//                    break;
//                case 2:
//                    showRevenueByMonth();
//                    break;
//                case 3:
//                    showTopProducts();
//                    break;
//                case 4:
//                    showOrderStatistics();
//                    break;
//                case 0:
//                    return;
//                default:
//                    Console.printError("Lua chon khong hop le");
//            }
//
//            System.out.println();
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