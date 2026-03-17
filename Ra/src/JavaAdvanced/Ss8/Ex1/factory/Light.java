package JavaAdvanced.Ss8.Ex1.factory;

public class Light implements Device {
    private String id;
    private int brightness;

    public Light(String id) {
        this.id = id;
        this.brightness = 100;
    }

    @Override
    public void turnOn() {
        System.out.println("Đèn " + id + ": Bật sáng.");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn " + id + ": Tắt.");
    }

    @Override
    public String getType() {
        return "Đèn";
    }
}