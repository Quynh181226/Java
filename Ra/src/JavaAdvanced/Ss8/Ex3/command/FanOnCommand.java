package JavaAdvanced.Ss8.Ex3.command;

import JavaAdvanced.Ss8.Ex3.devices.Fan;

public class FanOnCommand implements Command {
    private Fan fan;
    private int previousSpeed;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.on();
    }

    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
        System.out.println("  (Undo: Khôi phục tốc độ quạt)");
    }

    @Override
    public String getDescription() {
        return "Bật quạt " + fan.toString();
    }
}