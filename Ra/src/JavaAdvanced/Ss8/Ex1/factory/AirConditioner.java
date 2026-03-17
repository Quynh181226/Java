package JavaAdvanced.Ss8.Ex1.factory;

public class AirConditioner implements Device {
    private String id;
    private int temperature;

    public AirConditioner(String id) {
        this.id = id;
        this.temperature = 25;
    }

    @Override
    public void turnOn() {
        System.out.println("Điều hòa " + id + ": Bật làm mát.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa " + id + ": Tắt.");
    }

    @Override
    public String getType() {
        return "Điều hòa";
    }
}