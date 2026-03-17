package JavaAdvanced.Ss8.Ex2.facade;

// Interface cho các thiết bị (tái sử dụng từ bài 1)
public interface Device {
    void turnOn();
    void turnOff();
    String getType();
}

// Các lớp thiết bị cụ thể (có thể tái sử dụng từ bài 1)
class Light implements Device {
    private String id;

    public Light(String id) {
        this.id = id;
    }

    @Override
    public void turnOn() {
        System.out.println("Đèn " + id + ": Bật sáng.");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn " + id + ": Tắt.");
    }

    @Override
    public String getType() {
        return "Đèn";
    }
}

class Fan implements Device {
    private String id;
    private int speed;

    public Fan(String id) {
        this.id = id;
        this.speed = 0;
    }

    @Override
    public void turnOn() {
        System.out.println("Quạt " + id + ": Bật quạt.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt " + id + ": Tắt quạt.");
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        String speedText = speed == 1 ? "thấp" : (speed == 2 ? "trung bình" : "cao");
        System.out.println("Quạt " + id + ": Đặt tốc độ " + speedText + " (" + speed + ").");
    }

    @Override
    public String getType() {
        return "Quạt";
    }
}

class AirConditioner implements Device {
    private String id;
    private int temperature;

    public AirConditioner(String id) {
        this.id = id;
        this.temperature = 25;
    }

    @Override
    public void turnOn() {
        System.out.println("Điều hòa " + id + ": Bật làm mát ở " + temperature + "°C.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa " + id + ": Tắt.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Điều hòa " + id + ": Cài đặt nhiệt độ " + temperature + "°C.");
    }

    @Override
    public String getType() {
        return "Điều hòa";
    }
}