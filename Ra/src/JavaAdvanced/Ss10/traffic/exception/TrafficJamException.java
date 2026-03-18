package JavaAdvanced.Ss10.traffic.exception;

public class TrafficJamException extends Exception {
    public TrafficJamException(String message) {
        super("🚦 KẸT XE: " + message);
    }
}