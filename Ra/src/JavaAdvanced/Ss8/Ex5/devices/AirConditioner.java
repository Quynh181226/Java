package JavaAdvanced.Ss8.Ex5.devices;

import JavaAdvanced.Ss8.Ex5.observer.Observer;

public class AirConditioner implements Observer {
    private String name;
    private boolean isOn;
    private int temperature;
    private int previousTemperature;
    private boolean isSleepMode;

    public AirConditioner(String name) {
        this.name = name;
        this.isOn = false;
        this.temperature = 25;
        this.isSleepMode = false;
    }

    // Các phương thức điều khiển (cho Command)
    public void on() {
        isOn = true;
        System.out.println("❄️ Điều hòa " + name + ": BẬT ở " + temperature + "°C");
    }

    public void off() {
        isOn = false;
        System.out.println("❄️ Điều hòa " + name + ": TẮT");
    }

    public void setTemperature(int temperature) {
        if (temperature >= 16 && temperature <= 30) {
            this.previousTemperature = this.temperature;
            this.temperature = temperature;
            System.out.println("❄️ Điều hòa " + name + ": Đặt nhiệt độ = " + temperature + "°C");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPreviousTemperature() {
        return previousTemperature;
    }

    public void setSleepMode(boolean enabled) {
        this.isSleepMode = enabled;
    }

    // Observer pattern - tự động điều chỉnh theo nhiệt độ
    @Override
    public void update(int temperature) {
        System.out.print("📢 Điều hòa " + name + " nhận thông báo nhiệt độ " + temperature + "°C: ");

        if (!isOn) {
            System.out.println("Đang TẮT, không điều chỉnh");
            return;
        }

        if (isSleepMode) {
            // Trong chế độ ngủ, giữ nguyên nhiệt độ 28°C bất chấp nhiệt độ bên ngoài
            if (this.temperature != 28) {
                setTemperature(28);
            } else {
                System.out.println("Giữ nguyên nhiệt độ 28°C (chế độ ngủ)");
            }
        } else {
            // Logic thông thường
            if (temperature > 30 && this.temperature < 26) {
                setTemperature(26);
            } else if (temperature < 20 && this.temperature > 24) {
                setTemperature(24);
            } else {
                System.out.println("Không cần điều chỉnh");
            }
        }
    }

    @Override
    public String getName() {
        return "Điều hòa " + name;
    }

    public String getStatus() {
        if (!isOn) return "Điều hòa " + name + ": ⚫ TẮT";

        String sleepText = isSleepMode ? " (chế độ ngủ)" : "";
        return "Điều hòa " + name + ": 🟢 BẬT (" + temperature + "°C)" + sleepText;
    }
}