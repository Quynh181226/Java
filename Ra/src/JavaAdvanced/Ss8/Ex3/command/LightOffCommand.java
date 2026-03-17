package JavaAdvanced.Ss8.Ex3.command;

import JavaAdvanced.Ss8.Ex3.devices.Light;

public class LightOffCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.isOn();
        light.off();
    }

    @Override
    public void undo() {
        if (previousState) {
            light.on();
        } else {
            light.off();
        }
        System.out.println("  (Undo: Khôi phục trạng thái đèn)");
    }

    @Override
    public String getDescription() {
        return "Tắt đèn " + light.getLocation();
    }
}