package JavaAdvanced.Ss8.Ex1.factory;

public abstract class DeviceFactory {
    private static int deviceCounter = 0;

    public abstract Device createDevice();

    protected String generateDeviceId() {
        deviceCounter++;
        return String.format("%03d", deviceCounter);
    }
}