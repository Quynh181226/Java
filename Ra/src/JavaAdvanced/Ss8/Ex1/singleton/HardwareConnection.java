package JavaAdvanced.Ss8.Ex1.singleton;

public class HardwareConnection {
    // Instance duy nhất (Eager Initialization)
    private static final HardwareConnection instance = new HardwareConnection();
    private boolean isConnected;

    // Private constructor - không cho phép khởi tạo từ bên ngoài
    private HardwareConnection() {
        isConnected = false;
        System.out.println("HardwareConnection: Khởi tạo instance duy nhất.");
    }

    // Phương thức static để lấy instance
    public static HardwareConnection getInstance() {
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        } else {
            System.out.println("HardwareConnection: Đã kết nối trước đó, sử dụng kết nối hiện tại.");
        }
    }

    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            System.out.println("HardwareConnection: Đã ngắt kết nối phần cứng.");
        } else {
            System.out.println("HardwareConnection: Chưa kết nối.");
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}