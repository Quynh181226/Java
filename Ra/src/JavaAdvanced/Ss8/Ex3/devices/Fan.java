package JavaAdvanced.Ss8.Ex3.devices;

public class Fan {
    private String location;
    private int speed; // 0: OFF, 1: LOW, 2: MEDIUM, 3: HIGH

    public Fan(String location) {
        this.location = location;
        this.speed = 0;
    }

    public void on() {
        if (speed == 0) {
            speed = 1; // Mặc định bật ở tốc độ thấp
        }
        System.out.println("Quạt " + location + ": BẬT (tốc độ " + getSpeedText() + ")");
    }

    public void off() {
        speed = 0;
        System.out.println("Quạt " + location + ": TẮT");
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 3) {
            this.speed = speed;
            if (speed == 0) {
                System.out.println("Quạt " + location + ": TẮT");
            } else {
                System.out.println("Quạt " + location + ": Đặt tốc độ " + getSpeedText() + " (" + speed + ")");
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    private String getSpeedText() {
        switch (speed) {
            case 1: return "Thấp";
            case 2: return "Trung bình";
            case 3: return "Cao";
            default: return "Tắt";
        }
    }

    public String getStatus() {
        if (speed == 0) return "Quạt " + location + ": TẮT";
        return "Quạt " + location + ": BẬT (" + getSpeedText() + ")";
    }
}