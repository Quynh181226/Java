package JavaAdvanced.Ss8.Ex4.sensor;

import JavaAdvanced.Ss8.Ex4.observer.Observer;
import JavaAdvanced.Ss8.Ex4.observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private List<Observer> observers;
    private int temperature;
    private String location;

    public TemperatureSensor(String location) {
        this.observers = new ArrayList<>();
        this.location = location;
        this.temperature = 25; // Nhiệt độ mặc định
        System.out.println("Cảm biến nhiệt độ '" + location + "' đã được khởi tạo ở " + temperature + "°C");
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(observer.getName() + ": Đã đăng ký nhận thông báo từ cảm biến '" + location + "'");
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println(observer.getName() + ": Đã hủy đăng ký");
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n=== Cảm biến '" + location + "': Thông báo nhiệt độ thay đổi ===");
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    // Phương thức set nhiệt độ mới
    public void setTemperature(int newTemperature) {
        if (newTemperature < 0 || newTemperature > 50) {
            System.out.println("Nhiệt độ không hợp lệ! (0-50°C)");
            return;
        }

        if (this.temperature != newTemperature) {
            System.out.println("\n🔥 CẬP NHẬT NHIỆT ĐỘ: " + temperature + "°C → " + newTemperature + "°C");
            this.temperature = newTemperature;
            notifyObservers();
        } else {
            System.out.println("\n📌 Nhiệt độ không thay đổi: " + temperature + "°C");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }
}