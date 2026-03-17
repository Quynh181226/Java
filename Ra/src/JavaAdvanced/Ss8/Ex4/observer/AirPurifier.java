package JavaAdvanced.Ss8.Ex4.devices;

import JavaAdvanced.Ss8.Ex4.observer.Observer;

public class AirPurifier implements Observer {
    private String name;
    private boolean isOn;
    private int fanSpeed;
    private boolean uvLight;

    public AirPurifier(String name) {
        this.name = name;
        this.isOn = false;
        this.fanSpeed = 0;
        this.uvLight = false;
        System.out.println("Máy lọc không khí '" + name + "' đã được tạo");
    }

    @Override
    public void update(int temperature) {
        System.out.print("🍃 " + getName() + " nhận thông báo: ");

        if (temperature > 28) {
            // Nhiệt độ cao - nghi ngờ ô nhiễm
            isOn = true;
            fanSpeed = 3;
            uvLight = true;
            System.out.println("Phát hiện nhiệt độ cao, kích hoạt chế độ lọc MẠNH");
        } else if (temperature > 24) {
            isOn = true;
            fanSpeed = 2;
            uvLight = false;
            System.out.println("Chế độ lọc TRUNG BÌNH");
        } else if (temperature > 20) {
            isOn = true;
            fanSpeed = 1;
            uvLight = false;
            System.out.println("Chế độ lọc NHẸ");
        } else {
            isOn = false;
            fanSpeed = 0;
            uvLight = false;
            System.out.println("Nhiệt độ thấp, TẮT máy lọc");
        }

        System.out.println("   " + getStatus());
    }

    @Override
    public String getName() {
        return "Máy lọc không khí " + name;
    }

    public String getStatus() {
        if (!isOn) return "Máy lọc không khí " + name + ": 🔴 TẮT";

        String speedText = "";
        switch (fanSpeed) {
            case 1: speedText = "NHẸ"; break;
            case 2: speedText = "TRUNG BÌNH"; break;
            case 3: speedText = "MẠNH"; break;
        }

        String uvStatus = uvLight ? " (UV ON)" : "";
        return "Máy lọc không khí " + name + ": 🟢 BẬT (tốc độ " + speedText + ")" + uvStatus;
    }
}