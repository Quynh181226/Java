package JavaAdvanced.Ss8.Ex5.command;

import JavaAdvanced.Ss8.Ex5.devices.AirConditioner;

public class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemperature;
    private int previousTemperature;

    public ACSetTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.newTemperature = temperature;
    }

    @Override
    public void execute() {
        previousTemperature = ac.getTemperature();
        ac.setTemperature(newTemperature);
        if (!ac.getClass().getName().contains("isOn")) { // Kiểm tra đơn giản
            ac.on();
        }
    }

    @Override
    public void undo() {
        ac.setTemperature(previousTemperature);
        System.out.println("  (Undo: Khôi phục nhiệt độ " + previousTemperature + "°C)");
    }

    @Override
    public String getDescription() {
        return "Set điều hòa " + newTemperature + "°C";
    }
}