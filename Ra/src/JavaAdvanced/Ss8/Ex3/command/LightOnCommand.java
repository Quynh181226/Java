package JavaAdvanced.Ss8.Ex3.command;

import JavaAdvanced.Ss8.Ex3.devices.Light;

public class LightOnCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.isOn();
        light.on();
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
        return "Bật đèn " + light.getLocation();
    }
}