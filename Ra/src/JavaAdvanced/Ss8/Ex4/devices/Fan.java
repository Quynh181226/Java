package JavaAdvanced.Ss8.Ex4.devices;

import JavaAdvanced.Ss8.Ex4.observer.Observer;

public class Fan implements Observer {
    private String name;
    private boolean isOn;
    private int currentSpeed; // 0: OFF, 1: LOW, 2: MEDIUM, 3: HIGH

    public Fan(String name) {
        this.name = name;
        this.isOn = false;
        this.currentSpeed = 0;
        System.out.println("Quạt '" + name + "' đã được tạo (đang TẮT)");
    }

    @Override
    public void update(int temperature) {
        System.out.print("📢 " + getName() + " nhận thông báo: ");

        int newSpeed = calculateSpeedFromTemperature(temperature);
        adjustFanSpeed(newSpeed);
    }

    private int calculateSpeedFromTemperature(int temperature) {
        if (temperature < 20) {
            return 0; // TẮT
        } else if (temperature >= 20 && temperature <= 25) {
            return 1; // Tốc độ thấp
        } else if (temperature > 25 && temperature <= 30) {
            return 2; // Tốc độ trung bình
        } else {
            return 3; // Tốc độ cao
        }
    }

    private void adjustFanSpeed(int newSpeed) {
        String oldStatus = getStatus();

        if (newSpeed == 0) {
            if (isOn) {
                isOn = false;
                currentSpeed = 0;
                System.out.println("🌬️ Nhiệt độ thấp (<20°C), tự động TẮT quạt");
            } else {
                System.out.println("🌬️ Quạt đã TẮT (nhiệt độ <20°C)");
            }
        } else {
            if (!isOn) {
                isOn = true;
            }
            currentSpeed = newSpeed;

            switch (newSpeed) {
                case 1:
                    System.out.println("🌬️ Nhiệt độ phù hợp (20-25°C), chạy tốc độ THẤP");
                    break;
                case 2:
                    System.out.println("🌬️ Nhiệt độ hơi cao (25-30°C), chạy tốc độ TRUNG BÌNH");
                    break;
                case 3:
                    System.out.println("🌬️ Nhiệt độ cao (>30°C), chạy tốc độ MẠNH");
                    break;
            }
        }

        System.out.println("   " + getStatus());
    }

    @Override
    public String getName() {
        return "Quạt " + name;
    }

    public String getStatus() {
        if (!isOn) return "Quạt " + name + ": 🔴 TẮT";

        String speedText = "";
        switch (currentSpeed) {
            case 1: speedText = "THẤP"; break;
            case 2: speedText = "TRUNG BÌNH"; break;
            case 3: speedText = "CAO"; break;
        }
        return "Quạt " + name + ": 🟢 BẬT (tốc độ " + speedText + ")";
    }
}