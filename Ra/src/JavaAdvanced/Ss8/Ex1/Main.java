package JavaAdvanced.Ss8.Ex1;

import JavaAdvanced.Ss8.Ex1.singleton.HardwareConnection;
import JavaAdvanced.Ss8.Ex1.factory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static HardwareConnection hardware = HardwareConnection.getInstance();
    private static List<Device> devices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG ĐIỀU KHIỂN NHÀ THÔNG MINH ===");

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    connectHardware();
                    break;
                case 2:
                    createDevice();
                    break;
                case 3:
                    controlDevice();
                    break;
                case 4:
                    showDevices();
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    if (hardware.isConnected()) {
                        hardware.disconnect();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENU CHÍNH ---");
        System.out.println("1. Kết nối phần cứng");
        System.out.println("2. Tạo thiết bị mới");
        System.out.println("3. Điều khiển thiết bị");
        System.out.println("4. Xem danh sách thiết bị");
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

    private static void connectHardware() {
        System.out.println("\n--- KẾT NỐI PHẦN CỨNG ---");
        hardware.connect();
    }

    private static void createDevice() {
        if (!hardware.isConnected()) {
            System.out.println("Vui lòng kết nối phần cứng trước!");
            return;
        }

        System.out.println("\n--- TẠO THIẾT BỊ MỚI ---");
        System.out.println("Chọn loại thiết bị:");
        System.out.println("1. Đèn");
        System.out.println("2. Quạt");
        System.out.println("3. Điều hòa");
        System.out.print("Chọn: ");

        int type = getChoice();
        DeviceFactory factory = null;

        switch (type) {
            case 1:
                factory = new LightFactory();
                break;
            case 2:
                factory = new FanFactory();
                break;
            case 3:
                factory = new AirConditionerFactory();
                break;
            default:
                System.out.println("Loại thiết bị không hợp lệ!");
                return;
        }

        Device newDevice = factory.createDevice();
        devices.add(newDevice);
        System.out.println("Đã thêm thiết bị vào danh sách.");
    }

    private static void controlDevice() {
        if (devices.isEmpty()) {
            System.out.println("Chưa có thiết bị nào để điều khiển!");
            return;
        }

        System.out.println("\n--- ĐIỀU KHIỂN THIẾT BỊ ---");
        showDevices();

        System.out.print("Chọn số thứ tự thiết bị: ");
        int index = getChoice() - 1;

        if (index < 0 || index >= devices.size()) {
            System.out.println("Thiết bị không tồn tại!");
            return;
        }

        Device device = devices.get(index);
        System.out.println("\nĐiều khiển " + device.getType() + ":");
        System.out.println("1. Bật");
        System.out.println("2. Tắt");
        System.out.print("Chọn: ");

        int action = getChoice();

        switch (action) {
            case 1:
                device.turnOn();
                break;
            case 2:
                device.turnOff();
                break;
            default:
                System.out.println("Hành động không hợp lệ!");
        }
    }

    private static void showDevices() {
        if (devices.isEmpty()) {
            System.out.println("Danh sách thiết bị trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH THIẾT BỊ ---");
        for (int i = 0; i < devices.size(); i++) {
            Device device = devices.get(i);
            System.out.println((i + 1) + ". " + device.getType());
        }
    }
}