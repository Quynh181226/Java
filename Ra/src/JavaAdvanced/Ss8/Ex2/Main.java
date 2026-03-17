package JavaAdvanced.Ss8.Ex2;

import JavaAdvanced.Ss8.Ex2.adapter.*;
import JavaAdvanced.Ss8.Ex2.facade.SmartHomeFacade;
import java.util.Scanner;

public class Main {
    private static SmartHomeFacade smartHome;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo cảm biến cũ
        OldThermometer oldThermometer = new OldThermometer();

        // Tạo adapter để tích hợp cảm biến cũ
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        // Tạo facade cho nhà thông minh
        smartHome = new SmartHomeFacade(sensor);

        System.out.println("=== HỆ THỐNG ĐIỀU KHIỂN NHÀ THÔNG MINH - ADAPTER & FACADE ===");
        System.out.println("(Đã tích hợp cảm biến cũ qua Adapter)");

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    smartHome.getCurrentTemperature();
                    break;
                case 2:
                    smartHome.leaveHome();
                    break;
                case 3:
                    smartHome.sleepMode();
                    break;
                case 4:
                    testFixedTemperature();
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("--- MENU CHÍNH ---");
        System.out.println("1. Xem nhiệt độ hiện tại");
        System.out.println("2. Chế độ rời nhà (tắt tất cả thiết bị)");
        System.out.println("3. Chế độ ngủ");
        System.out.println("4. Test với nhiệt độ cố định");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void testFixedTemperature() {
        System.out.println("\n--- TEST NHIỆT ĐỘ CỐ ĐỊNH ---");
        System.out.println("Nhập nhiệt độ (°F) để test chuyển đổi:");
        System.out.print("(Ví dụ: 78°F tương đương 25.6°C): ");

        try {
            int fahrenheit = Integer.parseInt(scanner.nextLine());
            smartHome.getFixedTemperature(fahrenheit);
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số nguyên!");
        }
    }
}