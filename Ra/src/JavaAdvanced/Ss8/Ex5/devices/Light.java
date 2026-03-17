package JavaAdvanced.Ss8.Ex5.devices;

public class Light {
    private String name;
    private boolean isOn;

    public Light(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void on() {
        isOn = true;
        System.out.println("💡 Đèn " + name + ": BẬT");
    }

    public void off() {
        isOn = false;
        System.out.println("💡 Đèn " + name + ": TẮT");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return "Đèn " + name + ": " + (isOn ? "🟢 BẬT" : "⚫ TẮT");
    }
}