package JavaAdvanced.Ss8.Ex5;

import JavaAdvanced.Ss8.Ex5.devices.*;
import JavaAdvanced.Ss8.Ex5.command.*;
import JavaAdvanced.Ss8.Ex5.sensor.TemperatureSensor;
import JavaAdvanced.Ss8.Ex5.remote.RemoteControl;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Thiết bị
    private static Light livingRoomLight = new Light("Phòng khách");
    private static Light bedroomLight = new Light("Phòng ngủ");
    private static Fan bedroomFan = new Fan("Phòng ngủ");
    private static AirConditioner bedroomAC = new AirConditioner("Phòng ngủ");

    // Cảm biến
    private static TemperatureSensor bedroomSensor = new TemperatureSensor("Phòng ngủ");

    // Remote
    private static RemoteControl remote = new RemoteControl(5);

    public static void main(String[] args) {
        System.out.println("🏠=== HỆ THỐNG NHÀ THÔNG MINH - KỊCH BẢN NGỦ THÔNG MINH ===🏠");

        // Đăng ký thiết bị theo dõi cảm biến
        bedroomSensor.attach(bedroomFan);
        bedroomSensor.attach(bedroomAC);

        // Cấu hình remote
        setupRemote();

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    activateSleepMode();
                    break;
                case 2:
                    changeTemperature();
                    break;
                case 3:
                    pressRemoteButton();
                    break;
                case 4:
                    undo();
                    break;
                case 5:
                    redo();
                    break;
                case 6:
                    showStatus();
                    break;
                case 7:
                    showRemoteConfig();
                    break;
                case 8:
                    System.out.println("👋 Cảm ơn bạn đã sử dụng hệ thống!");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void setupRemote() {
        // Tạo SleepModeCommand
        SleepModeCommand sleepMode = new SleepModeCommand("Chế độ ngủ thông minh");

        // Thêm các command vào macro
        sleepMode.addCommand(new LightOffCommand(livingRoomLight));
        sleepMode.addCommand(new LightOffCommand(bedroomLight));
        sleepMode.addCommand(new ACSetTemperatureCommand(bedroomAC, 28));
        sleepMode.addCommand(new FanSetSpeedCommand(bedroomFan, 1));

        // Gán vào nút 1
        remote.setCommand(0, sleepMode);

        System.out.println("\n✅ Đã cấu hình remote sẵn sàng!");
        System.out.println("🔘 Nút 1: Chế độ ngủ thông minh");
    }

    private static void showMenu() {
        System.out.println("\n📋=== MENU ĐIỀU KHIỂN ===");
        System.out.println("1. 🌙 Kích hoạt chế độ ngủ (Nút 1)");
        System.out.println("2. 🌡️ Thay đổi nhiệt độ phòng ngủ");
        System.out.println("3. 🔘 Nhấn nút remote khác");
        System.out.println("4. ↩️ Undo");
        System.out.println("5. ↪️ Redo");
        System.out.println("6. 📊 Xem trạng thái thiết bị");
        System.out.println("7. 🎛️ Xem cấu hình remote");
        System.out.println("8. 🚪 Thoát");
        System.out.print("Chọn: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void activateSleepMode() {
        System.out.println("\n🌙=== KÍCH HOẠT CHẾ ĐỘ NGỦ ===");
        remote.pressButton(0);

        // Đánh dấu điều hòa đang ở chế độ ngủ
        bedroomAC.setSleepMode(true);
    }

    private static void changeTemperature() {
        System.out.println("\n🌡️=== THAY ĐỔI NHIỆT ĐỘ ===");
        System.out.println("Nhiệt độ hiện tại: " + bedroomSensor.getTemperature() + "°C");
        System.out.print("Nhập nhiệt độ mới (0-50°C): ");

        int newTemp = getChoice();
        bedroomSensor.setTemperature(newTemp);
    }

    private static void pressRemoteButton() {
        System.out.println("\n🔘=== NHẤN NÚT REMOTE ===");
        System.out.print("Nhập số nút (1-5): ");
        int slot = getChoice() - 1;

        if (slot >= 0 && slot < 5) {
            remote.pressButton(slot);
        } else {
            System.out.println("⚠️ Số nút không hợp lệ!");
        }
    }

    private static void undo() {
        remote.undo();
    }

    private static void redo() {
        remote.redo();
    }

    private static void showStatus() {
        System.out.println("\n📊=== TRẠNG THÁI THIẾT BỊ ===");
        System.out.println("🌡️ Nhiệt độ phòng ngủ: " + bedroomSensor.getTemperature() + "°C");
        System.out.println("------------------------");
        System.out.println(livingRoomLight.getStatus());
        System.out.println(bedroomLight.getStatus());
        System.out.println(bedroomFan.getStatus());
        System.out.println(bedroomAC.getStatus());
        System.out.println("============================\n");
    }

    private static void showRemoteConfig() {
        remote.showConfig();
    }
}