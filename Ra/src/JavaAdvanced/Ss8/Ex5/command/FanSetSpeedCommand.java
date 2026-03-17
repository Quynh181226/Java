package JavaAdvanced.Ss8.Ex5.command;

import JavaAdvanced.Ss8.Ex5.devices.Fan;

public class FanSetSpeedCommand implements Command {
    private Fan fan;
    private int newSpeed;
    private int previousSpeed;

    public FanSetSpeedCommand(Fan fan, int speed) {
        this.fan = fan;
        this.newSpeed = speed;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.setSpeed(newSpeed);
    }

    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
        System.out.println("  (Undo: Khôi phục tốc độ quạt)");
    }

    @Override
    public String getDescription() {
        String speedText = newSpeed == 1 ? "thấp" : (newSpeed == 2 ? "trung bình" : "cao");
        return "Set quạt tốc độ " + speedText;
    }
}