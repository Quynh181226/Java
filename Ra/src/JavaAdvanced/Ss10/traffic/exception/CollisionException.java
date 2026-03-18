package JavaAdvanced.Ss10.traffic.exception;

public class CollisionException extends Exception {
    public CollisionException(String message) {
        super("VA CHẠM: " + message);
    }
}