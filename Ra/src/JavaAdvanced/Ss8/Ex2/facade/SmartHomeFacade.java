package JavaAdvanced.Ss8.Ex2.facade;

import JavaAdvanced.Ss8.Ex2.adapter.TemperatureSensor;

public class SmartHomeFacade {
    private Light livingRoomLight;
    private Light bedroomLight;
    private Fan livingRoomFan;
    private Fan bedroomFan;
    private AirConditioner livingRoomAC;
    private AirConditioner bedroomAC;
    private TemperatureSensor temperatureSensor;

    public SmartHomeFacade(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;

        // Khởi tạo các thiết bị
        this.livingRoomLight = new Light("Phòng khách");
        this.bedroomLight = new Light("Phòng ngủ");
        this.livingRoomFan = new Fan("Phòng khách");
        this.bedroomFan = new Fan("Phòng ngủ");
        this.livingRoomAC = new AirConditioner("Phòng khách");
        this.bedroomAC = new AirConditioner("Phòng ngủ");
    }

    // Phương thức khi rời khỏi nhà - tắt tất cả thiết bị
    public void leaveHome() {
        System.out.println("\n=== FACADE: KÍCH HOẠT CHẾ ĐỘ RỜI NHÀ ===");

        // Tắt tất cả đèn
        livingRoomLight.turnOff();
        bedroomLight.turnOff();

        // Tắt tất cả quạt
        livingRoomFan.turnOff();
        bedroomFan.turnOff();

        // Tắt tất cả điều hòa
        livingRoomAC.turnOff();
        bedroomAC.turnOff();

        System.out.println("=== ĐÃ TẮT TẤT CẢ THIẾT BỊ ===\n");
    }

    // Phương thức chế độ ngủ
    public void sleepMode() {
        System.out.println("\n=== FACADE: KÍCH HOẠT CHẾ ĐỘ NGỦ ===");

        // Tắt đèn phòng khách
        livingRoomLight.turnOff();

        // Điều hòa phòng ngủ set 28°C
        bedroomAC.setTemperature(28);
        bedroomAC.turnOn();

        // Quạt phòng ngủ chạy tốc độ thấp
        bedroomFan.setSpeed(1); // speed = 1 là thấp
        bedroomFan.turnOn();

        // Điều hòa và quạt phòng khách tắt (không sử dụng khi ngủ)
        livingRoomAC.turnOff();
        livingRoomFan.turnOff();

        // Đèn phòng ngủ tắt
        bedroomLight.turnOff();

        System.out.println("=== CHẾ ĐỘ NGỦ ĐÃ ĐƯỢC KÍCH HOẠT ===\n");
    }

    // Phương thức lấy nhiệt độ hiện tại
    public void getCurrentTemperature() {
        System.out.println("\n=== ĐỌC NHIỆT ĐỘ ===");
        double celsius = temperatureSensor.getTemperatureCelsius();
        System.out.println("Nhiệt độ hiện tại: " + celsius + "°C");

        // Tính ngược lại độ F để hiển thị
        double fahrenheit = celsius * 9.0 / 5.0 + 32;
        System.out.println("(Tương đương: " + Math.round(fahrenheit) + "°F)");
        System.out.println();
    }

    // Phương thức test với nhiệt độ cố định
    public void getFixedTemperature(int fahrenheit) {
        System.out.println("\n=== ĐỌC NHIỆT ĐỘ (TEST) ===");
        System.out.println("Nhiệt độ từ cảm biến cũ: " + fahrenheit + "°F");

        // Giả lập chuyển đổi
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        celsius = Math.round(celsius * 10) / 10.0;

        System.out.println("Nhiệt độ sau chuyển đổi: " + celsius + "°C");
        System.out.println("(Adapter: " + fahrenheit + "°F → " + celsius + "°C)");
        System.out.println();
    }
}