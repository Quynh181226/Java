package JavaAdvanced.Ss8.Ex2.adapter;

import java.util.Random;

public class OldThermometer {
    private Random random = new Random();

    // Phương thức cũ trả về độ F (int)
    public int getTemperatureFahrenheit() {
        // Giả lập nhiệt độ ngẫu nhiên từ 60-90°F
        return 60 + random.nextInt(31);
    }

    // Phương thức để set nhiệt độ cụ thể (dùng cho test)
    public int getFixedTemperatureFahrenheit(int fahrenheit) {
        return fahrenheit;
    }
}