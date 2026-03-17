package JavaAdvanced.Ss8.Ex5.command;

import JavaAdvanced.Ss8.Ex5.devices.Light;

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
        }
        System.out.println("  (Undo: Khôi phục đèn)");
    }

    @Override
    public String getDescription() {
        return "Tắt đèn " + light.getName();
    }
}