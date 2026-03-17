package JavaAdvanced.Ss8.Ex1.factory;

public class Fan implements Device {
    private String id;
    private int speed;

    public Fan(String id) {
        this.id = id;
        this.speed = 0;
    }

    @Override
    public void turnOn() {
        System.out.println("Quạt " + id + ": Bật quạt.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt " + id + ": Tắt quạt.");
    }

    @Override
    public String getType() {
        return "Quạt";
    }
}