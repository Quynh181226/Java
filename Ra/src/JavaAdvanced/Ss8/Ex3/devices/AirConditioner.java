package JavaAdvanced.Ss8.Ex3.devices;

public class AirConditioner {
    private String location;
    private boolean isOn;
    private int temperature;
    private int previousTemperature;

    public AirConditioner(String location) {
        this.location = location;
        this.isOn = false;
        this.temperature = 25; // Nhiệt độ mặc định
        this.previousTemperature = 25;
    }

    public void on() {
        isOn = true;
        System.out.println("Điều hòa " + location + ": BẬT ở " + temperature + "°C");
    }

    public void off() {
        isOn = false;
        System.out.println("Điều hòa " + location + ": TẮT");
    }

    public void setTemperature(int temperature) {
        if (temperature >= 16 && temperature <= 30) {
            this.previousTemperature = this.temperature;
            this.temperature = temperature;
            System.out.println("Điều hòa " + location + ": Đặt nhiệt độ = " + temperature + "°C");
        } else {
            System.out.println("Nhiệt độ không hợp lệ! (16-30°C)");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPreviousTemperature() {
        return previousTemperature;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getStatus() {
        if (!isOn) return "Điều hòa " + location + ": TẮT";
        return "Điều hòa " + location + ": BẬT (" + temperature + "°C)";
    }
}