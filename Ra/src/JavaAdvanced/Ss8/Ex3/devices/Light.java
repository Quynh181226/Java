package JavaAdvanced.Ss8.Ex3.devices;

public class Light {
    private String location;
    private boolean isOn;

    public Light(String location) {
        this.location = location;
        this.isOn = false;
    }

    public void on() {
        isOn = true;
        System.out.println("Đèn " + location + ": BẬT");
    }

    public void off() {
        isOn = false;
        System.out.println("Đèn " + location + ": TẮT");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return "Đèn " + location + ": " + (isOn ? "BẬT" : "TẮT");
    }
}