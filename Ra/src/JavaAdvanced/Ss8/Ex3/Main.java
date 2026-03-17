package JavaAdvanced.Ss8.Ex3;

import JavaAdvanced.Ss8.Ex3.devices.*;
import JavaAdvanced.Ss8.Ex3.command.*;
import JavaCore.Ss10.B4;

import java.util.Scanner;

public class Main {
    private static B4.RemoteControl remote = new B4.RemoteControl();
    private static Scanner scanner = new Scanner(System.in);

    // Khởi tạo các thiết bị
    private static Light livingRoomLight = new Light("Phòng khách");
    private static Light bedroomLight = new Light("Phòng ngủ");
    private static Fan livingRoomFan = new Fan("Phòng khách");
    private static Fan bedroomFan = new Fan("Phòng ngủ");
    private static AirConditioner livingRoomAC = new AirConditioner("Phòng khách");
    private static AirConditioner bedroomAC = new AirConditioner("Phòng ngủ");

    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG REMOTE ĐIỀU KHIỂN THIẾT BỊ - COMMAND PATTERN ===");

        // Cấu hình remote mặc định
        setupDefaultCommands();

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    pressButton();
                    break;
                case 2:
                    assignCommand();
                    break;
                case 3:
                    remote.undo();
                    break;
                case 4:
                    remote.redo();
                    break;
                case 5:
                    remote.showConfig();
                    break;
                case 6:
                    showDeviceStatus();
                    break;
                case 7:
                    demoMacroCommand();
                    break;
                case 8:
                    System.out.println("Cảm ơn bạn đã sử dụng remote!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENU REMOTE ---");
        System.out.println("1. Nhấn nút trên remote");
        System.out.println("2. Gán chức năng cho nút");
        System.out.println("3. Undo");
        System.out.println("4. Redo");
        System.out.println("5. Xem cấu hình remote");
        System.out.println("6. Xem trạng thái thiết bị");
        System.out.println("7. Demo Macro Command");
        System.out.println("8. Thoát");
        System.out.print("Chọn: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void setupDefaultCommands() {
        // Gán các command mặc định
        remote.setOnCommand(0, new LightOnCommand(livingRoomLight));
        remote.setOffCommand(0, new LightOffCommand(livingRoomLight));

        remote.setOnCommand(1, new LightOnCommand(bedroomLight));
        remote.setOffCommand(1, new LightOffCommand(bedroomLight));

        remote.setOnCommand(2, new FanOnCommand(livingRoomFan));
        remote.setOffCommand(2, new FanOffCommand(livingRoomFan));

        remote.setOnCommand(3, new FanOnCommand(bedroomFan));
        remote.setOffCommand(3, new FanOffCommand(bedroomFan));

        remote.setOnCommand(4, new ACSetTemperatureCommand(livingRoomAC, 26));
        remote.setOffCommand(4, new ACSetTemperatureCommand(livingRoomAC, 25));

        System.out.println("Đã cấu hình remote với các chức năng mặc định.");
    }

    private static void pressButton() {
        System.out.println("\n--- NHẤN NÚT REMOTE ---");
        System.out.print("Nhập slot (1-10): ");
        int slot = getChoice() - 1;

        if (slot < 0 || slot >= 10) {
            System.out.println("Slot không hợp lệ!");
            return;
        }

        System.out.println("Chọn nút:");
        System.out.println("1. Nút On");
        System.out.println("2. Nút Off");
        System.out.print("Chọn: ");

        int button = getChoice();

        if (button == 1) {
            remote.pressOnButton(slot);
        } else if (button == 2) {
            remote.pressOffButton(slot);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void assignCommand() {
        System.out.println("\n--- GÁN CHỨC NĂNG CHO NÚT ---");
        System.out.print("Nhập slot (1-10): ");
        int slot = getChoice() - 1;

        if (slot < 0 || slot >= 10) {
            System.out.println("Slot không hợp lệ!");
            return;
        }

        System.out.println("Chọn loại command:");
        System.out.println("1. Bật đèn phòng khách");
        System.out.println("2. Tắt đèn phòng khách");
        System.out.println("3. Bật đèn phòng ngủ");
        System.out.println("4. Tắt đèn phòng ngủ");
        System.out.println("5. Bật quạt phòng khách");
        System.out.println("6. Tắt quạt phòng khách");
        System.out.println("7. Bật quạt phòng ngủ");
        System.out.println("8. Tắt quạt phòng ngủ");
        System.out.println("9. Set điều hòa phòng khách 26°C");
        System.out.println("10. Set điều hòa phòng ngủ 24°C");
        System.out.print("Chọn: ");

        int type = getChoice();
        Command cmd = null;

        switch (type) {
            case 1: cmd = new LightOnCommand(livingRoomLight); break;
            case 2: cmd = new LightOffCommand(livingRoomLight); break;
            case 3: cmd = new LightOnCommand(bedroomLight); break;
            case 4: cmd = new LightOffCommand(bedroomLight); break;
            case 5: cmd = new FanOnCommand(livingRoomFan); break;
            case 6: cmd = new FanOffCommand(livingRoomFan); break;
            case 7: cmd = new FanOnCommand(bedroomFan); break;
            case 8: cmd = new FanOffCommand(bedroomFan); break;
            case 9: cmd = new ACSetTemperatureCommand(livingRoomAC, 26); break;
            case 10: cmd = new ACSetTemperatureCommand(bedroomAC, 24); break;
            default: System.out.println("Lựa chọn không hợp lệ!"); return;
        }

        System.out.println("Gán cho nút:");
        System.out.println("1. Nút On");
        System.out.println("2. Nút Off");
        System.out.print("Chọn: ");

        int button = getChoice();

        if (button == 1) {
            remote.setOnCommand(slot, cmd);
            System.out.println("Đã gán " + cmd.getDescription() + " cho nút On slot " + (slot + 1));
        } else if (button == 2) {
            remote.setOffCommand(slot, cmd);
            System.out.println("Đã gán " + cmd.getDescription() + " cho nút Off slot " + (slot + 1));
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void showDeviceStatus() {
        System.out.println("\n=== TRẠNG THÁI THIẾT BỊ ===");
        System.out.println(livingRoomLight.getStatus());
        System.out.println(bedroomLight.getStatus());
        System.out.println(livingRoomFan.getStatus());
        System.out.println(bedroomFan.getStatus());
        System.out.println(livingRoomAC.getStatus());
        System.out.println(bedroomAC.getStatus());
        System.out.println("==========================\n");
    }

    private static void demoMacroCommand() {
        System.out.println("\n=== DEMO MACRO COMMAND ===");

        // Tạo macro "Good Night" - tắt hết thiết bị trước khi ngủ
        MacroCommand goodNightMacro = new MacroCommand("Good Night");
        goodNightMacro.addCommand(new LightOffCommand(livingRoomLight));
        goodNightMacro.addCommand(new LightOffCommand(bedroomLight));
        goodNightMacro.addCommand(new FanOffCommand(livingRoomFan));
        goodNightMacro.addCommand(new FanOffCommand(bedroomFan));

        // Tạo macro "Movie Mode"
        MacroCommand movieModeMacro = new MacroCommand("Movie Mode");
        movieModeMacro.addCommand(new LightOffCommand(livingRoomLight));
        movieModeMacro.addCommand(new LightOffCommand(bedroomLight));
        movieModeMacro.addCommand(new FanOnCommand(livingRoomFan));

        // Gán macro vào remote
        remote.setOnCommand(8, goodNightMacro);
        remote.setOnCommand(9, movieModeMacro);

        System.out.println("Đã gán Macro 'Good Night' vào slot 9 (On)");
        System.out.println("Đã gán Macro 'Movie Mode' vào slot 10 (On)");
    }
}