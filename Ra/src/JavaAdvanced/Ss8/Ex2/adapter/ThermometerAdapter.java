package JavaAdvanced.Ss8.Ex2.adapter;

public class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        // Lấy nhiệt độ từ cảm biến cũ (độ F)
        int fahrenheit = oldThermometer.getTemperatureFahrenheit();

        // Chuyển đổi sang độ C: (°F - 32) × 5/9 = °C
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        // Làm tròn 1 chữ số thập phân
        return Math.round(celsius * 10) / 10.0;
    }

    // Phương thức test với nhiệt độ cố định
    public double getFixedTemperatureCelsius(int fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return Math.round(celsius * 10) / 10.0;
    }
}