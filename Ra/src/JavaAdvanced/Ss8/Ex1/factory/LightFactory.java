package JavaAdvanced.Ss8.Ex1.factory;

public class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        String id = generateDeviceId();
        System.out.println("LightFactory: Đã tạo đèn mới (ID: " + id + ").");
        return new Light(id);
    }
}