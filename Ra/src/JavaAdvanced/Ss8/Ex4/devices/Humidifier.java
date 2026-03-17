package JavaAdvanced.Ss8.Ex4.devices;

import JavaAdvanced.Ss8.Ex4.observer.Observer;

public class Humidifier implements Observer {
    private String name;
    private boolean isOn;
    private int humidityLevel; // 0-100%

    public Humidifier(String name) {
        this.name = name;
        this.isOn = false;
        this.humidityLevel = 50; // Độ ẩm mặc định
        System.out.println("Máy tạo ẩm '" + name + "' đã được tạo (độ ẩm " + humidityLevel + "%)");
    }

    @Override
    public void update(int temperature) {
        System.out.print("💧 " + getName() + " nhận thông báo: ");
        adjustHumidity(temperature);
    }

    private void adjustHumidity(int temperature) {
        // Tính độ ẩm lý tưởng dựa trên nhiệt độ
        int targetHumidity = calculateIdealHumidity(temperature);

        System.out.println("Điều chỉnh độ ẩm cho nhiệt độ " + temperature + "°C");

        if (Math.abs(humidityLevel - targetHumidity) > 5) {
            // Cần điều chỉnh lớn
            if (humidityLevel < targetHumidity) {
                System.out.println("   💧 Tăng độ ẩm từ " + humidityLevel + "% → " + targetHumidity + "%");
                humidityLevel = targetHumidity;
                isOn = true;
            } else if (humidityLevel > targetHumidity) {
                System.out.println("   💧 Giảm độ ẩm từ " + humidityLevel + "% → " + targetHumidity + "%");
                humidityLevel = targetHumidity;
                isOn = true;
            }
        } else if (Math.abs(humidityLevel - targetHumidity) > 0) {
            // Điều chỉnh nhỏ
            System.out.println("   💧 Điều chỉnh nhẹ độ ẩm: " + humidityLevel + "% → " + targetHumidity + "%");
            humidityLevel = targetHumidity;
            isOn = true;
        } else {
            System.out.println("   💧 Độ ẩm đã ở mức lý tưởng: " + humidityLevel + "%");
        }

        // Tự động tắt nếu độ ẩm đạt mức lý tưởng và nhiệt độ phù hợp
        if (temperature >= 20 && temperature <= 25 && humidityLevel == targetHumidity) {
            isOn = false;
            System.out.println("   💧 Máy tạo ẩm tự động TẮT (điều kiện lý tưởng)");
        }

        System.out.println("   " + getStatus());
    }

    private int calculateIdealHumidity(int temperature) {
        // Công thức đơn giản: nhiệt độ càng cao, độ ẩm càng thấp
        if (temperature < 20) {
            return 60; // Trời lạnh cần độ ẩm cao
        } else if (temperature <= 25) {
            return 50; // Dễ chịu
        } else if (temperature <= 30) {
            return 45; // Hơi nóng, giảm ẩm
        } else {
            return 40; // Nóng, cần giảm ẩm để dễ chịu hơn
        }
    }

    @Override
    public String getName() {
        return "Máy tạo ẩm " + name;
    }

    public String getStatus() {
        String status = isOn ? "🟢 BẬT" : "🔴 TẮT";
        return "Máy tạo ẩm " + name + ": " + status + " (độ ẩm " + humidityLevel + "%)";
    }
}