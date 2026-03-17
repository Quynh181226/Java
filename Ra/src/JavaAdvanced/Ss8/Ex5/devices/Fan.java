package JavaAdvanced.Ss8.Ex5.devices;

import JavaAdvanced.Ss8.Ex5.observer.Observer;

public class Fan implements Observer {
    private String name;
    private int speed; // 0: OFF, 1: LOW, 2: MEDIUM, 3: HIGH
    private boolean isOn;
    private int previousSpeed;

    public Fan(String name) {
        this.name = name;
        this.speed = 0;
        this.isOn = false;
    }

    // Các phương thức điều khiển (cho Command)
    public void on() {
        if (speed == 0) {
            speed = 1;
        }
        isOn = true;
        System.out.println("🌀 Quạt " + name + ": BẬT (tốc độ " + getSpeedText() + ")");
    }

    public void off() {
        isOn = false;
        speed = 0;
        System.out.println("🌀 Quạt " + name + ": TẮT");
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 3) {
            this.previousSpeed = this.speed;
            this.speed = speed;
            this.isOn = (speed > 0);

            if (speed == 0) {
                System.out.println("🌀 Quạt " + name + ": TẮT");
            } else {
                System.out.println("🌀 Quạt " + name + ": Đặt tốc độ " + getSpeedText() + " (" + speed + ")");
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getPreviousSpeed() {
        return previousSpeed;
    }

    private String getSpeedText() {
        switch (speed) {
            case 1: return "THẤP";
            case 2: return "TRUNG BÌNH";
            case 3: return "CAO";
            default: return "TẮT";
        }
    }

    // Observer pattern - tự động điều chỉnh theo nhiệt độ
    @Override
    public void update(int temperature) {
        System.out.print("📢 Quạt " + name + " nhận thông báo nhiệt độ " + temperature + "°C: ");

        if (temperature >= 30) {
            setSpeed(3); // Tốc độ cao
        } else if (temperature >= 26) {
            setSpeed(2); // Tốc độ trung bình
        } else if (temperature >= 22) {
            setSpeed(1); // Tốc độ thấp
        } else {
            setSpeed(0); // Tắt
        }
    }

    @Override
    public String getName() {
        return "Quạt " + name;
    }

    public String getStatus() {
        if (!isOn || speed == 0) return "Quạt " + name + ": ⚫ TẮT";

        String speedText = "";
        switch (speed) {
            case 1: speedText = "THẤP"; break;
            case 2: speedText = "TRUNG BÌNH"; break;
            case 3: speedText = "CAO"; break;
        }
        return "Quạt " + name + ": 🟢 BẬT (tốc độ " + speedText + ")";
    }
}