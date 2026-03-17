package JavaAdvanced.Ss8.Ex1.factory;

public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        String id = generateDeviceId();
        System.out.println("FanFactory: Đã tạo quạt mới (ID: " + id + ").");
        return new Fan(id);
    }
}