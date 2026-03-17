package JavaAdvanced.Ss8.Ex1.factory;

public class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        String id = generateDeviceId();
        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới (ID: " + id + ").");
        return new AirConditioner(id);
    }
}