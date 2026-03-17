package JavaAdvanced.Ss8.Ex5.sensor;

import JavaAdvanced.Ss8.Ex5.observer.Observer;
import JavaAdvanced.Ss8.Ex5.observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private List<Observer> observers;
    private int temperature;
    private String location;

    public TemperatureSensor(String location) {
        this.observers = new ArrayList<>();
        this.location = location;
        this.temperature = 25;
        System.out.println("🌡️ Cảm biến nhiệt độ '" + location + "' khởi tạo ở " + temperature + "°C");
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("✅ " + observer.getName() + " đã đăng ký theo dõi cảm biến '" + location + "'");
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("❌ " + observer.getName() + " đã hủy đăng ký");
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n📢 Cảm biến '" + location + "' thông báo: NHIỆT ĐỘ = " + temperature + "°C");
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        if (newTemperature < 0 || newTemperature > 50) {
            System.out.println("Nhiệt độ không hợp lệ!");
            return;
        }

        if (this.temperature != newTemperature) {
            System.out.println("\n🔥 NHIỆT ĐỘ THAY ĐỔI: " + this.temperature + "°C → " + newTemperature + "°C");
            this.temperature = newTemperature;
            notifyObservers();
        } else {
            System.out.println("\n📌 Nhiệt độ không đổi: " + temperature + "°C");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }
}