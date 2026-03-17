package JavaAdvanced.Ss8.Ex4;

import JavaAdvanced.Ss8.Ex4.devices.AirPurifier;
import JavaAdvanced.Ss8.Ex4.sensor.TemperatureSensor;
import JavaAdvanced.Ss8.Ex4.devices.*;
import java.util.Scanner;

public class Main {
    private static TemperatureSensor livingRoomSensor;
    private static TemperatureSensor bedroomSensor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG CẢM BIẾN NHIỆT ĐỘ TỰ ĐỘNG - OBSERVER PATTERN ===");

        // Khởi tạo các cảm biến
        livingRoomSensor = new TemperatureSensor("Phòng khách");
        bedroomSensor = new TemperatureSensor("Phòng ngủ");

        // Khởi tạo các thiết bị
        Fan livingRoomFan = new Fan("Phòng khách");
        Fan bedroomFan = new Fan("Phòng ngủ");
        Humidifier mainHumidifier = new Humidifier("Chính");
        AirPurifier livingRoomPurifier = new AirPurifier("Phòng khách");

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    registerDevices(livingRoomFan, bedroomFan, mainHumidifier, livingRoomPurifier);
                    break;
                case 2:
                    changeTemperature();
                    break;
                case 3:
                    showDeviceStatus(livingRoomFan, bedroomFan, mainHumidifier, livingRoomPurifier);
                    break;
                case 4:
                    unregisterDevices(livingRoomFan, bedroomFan, mainHumidifier, livingRoomPurifier);
                    break;
                case 5:
                    demoSequence();
                    break;
                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENU CHÍNH ---");
        System.out.println("1. Đăng ký thiết bị theo dõi nhiệt độ");
        System.out.println("2. Thay đổi nhiệt độ");
        System.out.println("3. Xem trạng thái thiết bị");
        System.out.println("4. Hủy đăng ký thiết bị");
        System.out.println("5. Demo chuỗi thay đổi nhiệt độ");
        System.out.println("6. Thoát");
        System.out.print("Chọn: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void registerDevices(Fan fan1, Fan fan2, Humidifier humidifier, AirPurifier purifier) {
        System.out.println("\n--- ĐĂNG KÝ THIẾT BỊ ---");
        System.out.println("Chọn cảm biến:");
        System.out.println("1. Phòng khách");
        System.out.println("2. Phòng ngủ");
        System.out.println("3. Cả hai");
        System.out.print("Chọn: ");

        int sensorChoice = getChoice();

        System.out.println("Chọn thiết bị:");
        System.out.println("1. Quạt phòng khách");
        System.out.println("2. Quạt phòng ngủ");
        System.out.println("3. Máy tạo ẩm");
        System.out.println("4. Máy lọc không khí");
        System.out.println("5. Tất cả");
        System.out.print("Chọn: ");

        int deviceChoice = getChoice();

        // Xác định cảm biến
        TemperatureSensor[] sensors;
        if (sensorChoice == 1) {
            sensors = new TemperatureSensor[]{livingRoomSensor};
        } else if (sensorChoice == 2) {
            sensors = new TemperatureSensor[]{bedroomSensor};
        } else if (sensorChoice == 3) {
            sensors = new TemperatureSensor[]{livingRoomSensor, bedroomSensor};
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        // Đăng ký thiết bị
        for (TemperatureSensor sensor : sensors) {
            switch (deviceChoice) {
                case 1:
                    sensor.attach(fan1);
                    break;
                case 2:
                    sensor.attach(fan2);
                    break;
                case 3:
                    sensor.attach(humidifier);
                    break;
                case 4:
                    sensor.attach(purifier);
                    break;
                case 5:
                    sensor.attach(fan1);
                    sensor.attach(fan2);
                    sensor.attach(humidifier);
                    sensor.attach(purifier);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
        }
    }

    private static void changeTemperature() {
        System.out.println("\n--- THAY ĐỔI NHIỆT ĐỘ ---");
        System.out.println("Chọn cảm biến:");
        System.out.println("1. Phòng khách");
        System.out.println("2. Phòng ngủ");
        System.out.print("Chọn: ");

        int sensorChoice = getChoice();
        TemperatureSensor sensor;

        if (sensorChoice == 1) {
            sensor = livingRoomSensor;
        } else if (sensorChoice == 2) {
            sensor = bedroomSensor;
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Nhập nhiệt độ mới (0-50°C): ");
        int temp = getChoice();

        sensor.setTemperature(temp);
    }

    private static void showDeviceStatus(Fan fan1, Fan fan2, Humidifier humidifier, AirPurifier purifier) {
        System.out.println("\n=== TRẠNG THÁI THIẾT BỊ ===");
        System.out.println("Cảm biến phòng khách: " + livingRoomSensor.getTemperature() + "°C");
        System.out.println("Cảm biến phòng ngủ: " + bedroomSensor.getTemperature() + "°C");
        System.out.println("------------------------");
        System.out.println(fan1.getStatus());
        System.out.println(fan2.getStatus());
        System.out.println(humidifier.getStatus());
        System.out.println(purifier.getStatus());
        System.out.println("==========================\n");
    }

    private static void unregisterDevices(Fan fan1, Fan fan2, Humidifier humidifier, AirPurifier purifier) {
        System.out.println("\n--- HỦY ĐĂNG KÝ THIẾT BỊ ---");
        System.out.println("Chọn thiết bị:");
        System.out.println("1. Quạt phòng khách");
        System.out.println("2. Quạt phòng ngủ");
        System.out.println("3. Máy tạo ẩm");
        System.out.println("4. Máy lọc không khí");
        System.out.print("Chọn: ");

        int choice = getChoice();

        switch (choice) {
            case 1:
                livingRoomSensor.detach(fan1);
                bedroomSensor.detach(fan1);
                break;
            case 2:
                livingRoomSensor.detach(fan2);
                bedroomSensor.detach(fan2);
                break;
            case 3:
                livingRoomSensor.detach(humidifier);
                bedroomSensor.detach(humidifier);
                break;
            case 4:
                livingRoomSensor.detach(purifier);
                bedroomSensor.detach(purifier);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void demoSequence() {
        System.out.println("\n=== DEMO CHUỖI THAY ĐỔI NHIỆT ĐỘ ===");

        // Đăng ký tất cả thiết bị cho cả hai cảm biến
        Fan demoFan = new Fan("Demo");
        Humidifier demoHumidifier = new Humidifier("Demo");

        livingRoomSensor.attach(demoFan);
        livingRoomSensor.attach(demoHumidifier);

        System.out.println("\n📋 Kịch bản 1: Nhiệt độ thấp");
        livingRoomSensor.setTemperature(18);

        System.out.println("\n📋 Kịch bản 2: Nhiệt độ dễ chịu");
        livingRoomSensor.setTemperature(23);

        System.out.println("\n📋 Kịch bản 3: Nhiệt độ cao");
        livingRoomSensor.setTemperature(28);

        System.out.println("\n📋 Kịch bản 4: Nhiệt độ rất cao");
        livingRoomSensor.setTemperature(32);

        // Hủy đăng ký
        livingRoomSensor.detach(demoFan);
        livingRoomSensor.detach(demoHumidifier);
    }
}