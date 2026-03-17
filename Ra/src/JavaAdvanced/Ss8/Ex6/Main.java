package JavaAdvanced.Ss8.Ex6;

import JavaAdvanced.Ss8.Ex6.factory.*;
import JavaAdvanced.Ss8.Ex6.model.Product;
import JavaAdvanced.Ss8.Ex6.model.Order;
import JavaAdvanced.Ss8.Ex6.service.OrderService;
import JavaAdvanced.Ss8.Ex6.singleton.OrderLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();
    private static OrderLogger logger = OrderLogger.getInstance();

    public static void main(String[] args) {
        initializeProducts();

        System.out.println("==========================================");
        System.out.println("  HỆ THỐNG BÁN HÀNG ĐA KÊNH");
        System.out.println("  (Abstract Factory + Strategy + Adapter)");
        System.out.println("==========================================");

        while (true) {
            SalesChannelFactory factory = selectChannel();
            if (factory == null) {
                break;
            }

            processChannelOrder(factory);
        }

        logger.close();
        System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
    }

    private static void initializeProducts() {
        products.add(new Product("P001", "Laptop Dell XPS 13", 15000000));
        products.add(new Product("P002", "Điện thoại iPhone 14", 12000000));
        products.add(new Product("P003", "Tai nghe Sony WH-1000XM4", 3500000));
        products.add(new Product("P004", "Máy tính bảng iPad Air", 8000000));
        products.add(new Product("P005", "Đồng hồ thông minh Galaxy Watch", 4500000));
        products.add(new Product("P006", "Bàn phím cơ Logitech", 1200000));
        products.add(new Product("P007", "Chuột không dây MX Master 3", 1800000));
        products.add(new Product("P008", "Màn hình LG 27 inch 4K", 6500000));
    }

    private static SalesChannelFactory selectChannel() {
        System.out.println("\n--- CHỌN KÊNH BÁN HÀNG ---");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS (Cửa hàng)");
        System.out.println("4. Kiosk tự động (Mới)");
        System.out.println("5. Thoát");
        System.out.print("Chọn: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                System.out.println("Bạn đã chọn kênh WEBSITE");
                return new WebsiteFactory();
            case 2:
                System.out.println("Bạn đã chọn kênh MOBILE APP");
                return new MobileAppFactory();
            case 3:
                System.out.println("Bạn đã chọn kênh POS (CỬA HÀNG)");
                return new POSFactory();
            case 4:
                System.out.println("Bạn đã chọn kênh KIOSK TỰ ĐỘNG");
                return new KioskFactory();
            case 5:
                return null;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return selectChannel();
        }
    }

    private static void processChannelOrder(SalesChannelFactory factory) {
        System.out.println("\n--- NHẬP THÔNG TIN ĐƠN HÀNG ---");

        // Nhập thông tin khách hàng
        System.out.print("Họ tên khách hàng: ");
        String customerName = scanner.nextLine();

        // Thu thập thông tin thanh toán theo từng kênh
        String[] paymentParams = collectPaymentInfo(factory);

        // Tạo OrderService với factory và tham số thanh toán
        OrderService orderService = new OrderService(factory, paymentParams);

        // Tạo đơn hàng mới
        Order order = orderService.createOrder(customerName);

        // Nhập thông tin liên lạc
        System.out.print("Email (nếu có): ");
        String email = scanner.nextLine();
        System.out.print("Số điện thoại (nếu có): ");
        String phone = scanner.nextLine();
        if (!email.isEmpty() || !phone.isEmpty()) {
            orderService.setCustomerContact(order, email, phone);
        }

        // Thêm sản phẩm vào đơn hàng
        addProductsToOrder(orderService, order);

        // Xử lý đơn hàng
        orderService.processOrder(order);
    }

    private static String[] collectPaymentInfo(SalesChannelFactory factory) {
        if (factory instanceof WebsiteFactory) {
            System.out.print("Số thẻ tín dụng: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Tên chủ thẻ: ");
            String cardHolder = scanner.nextLine();
            return new String[]{cardNumber, cardHolder};
        } else if (factory instanceof MobileAppFactory) {
            System.out.print("Số điện thoại MoMo: ");
            String phone = scanner.nextLine();
            return new String[]{phone};
        } else if (factory instanceof POSFactory) {
            System.out.print("Địa chỉ giao hàng: ");
            String address = scanner.nextLine();
            return new String[]{address};
        } else if (factory instanceof KioskFactory) {
            System.out.print("Số thẻ: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Ngân hàng: ");
            String bankName = scanner.nextLine();
            return new String[]{cardNumber, bankName};
        }
        return new String[]{};
    }

    private static void addProductsToOrder(OrderService orderService, Order order) {
        while (true) {
            System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.println("0. Hoàn tất chọn sản phẩm");

            System.out.print("Chọn sản phẩm (0-8): ");
            int choice = getIntInput();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > products.size()) {
                System.out.println("Sản phẩm không hợp lệ!");
                continue;
            }

            Product selected = products.get(choice - 1);
            System.out.print("Số lượng: ");
            int quantity = getIntInput();

            if (quantity <= 0) {
                System.out.println("Số lượng không hợp lệ!");
                continue;
            }

            orderService.addProduct(order, selected, quantity);
        }
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}