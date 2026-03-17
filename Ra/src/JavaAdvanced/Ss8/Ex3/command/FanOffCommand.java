package JavaAdvanced.Ss8.Ex3.command;

import JavaAdvanced.Ss8.Ex3.devices.Fan;

public class FanOffCommand implements Command {
    private Fan fan;
    private int previousSpeed;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
        System.out.println("  (Undo: Khôi phục tốc độ quạt)");
    }

    @Override
    public String getDescription() {
        return "Tắt quạt " + fan.toString();
    }
}