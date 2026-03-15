package JavaAdvanced.Ss6.Ex5;

public class Ticket {

    private String id;
    private boolean isVIP;
    private boolean isHeld;
    private long holdExpiryTime;

    public Ticket(String id) {
        this.id = id;
        this.isHeld = false;
    }

    public String getId() {
        return id;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void hold(long expiryTime) {
        this.isHeld = true;
        this.holdExpiryTime = expiryTime;
    }

    public void release() {
        this.isHeld = false;
        this.holdExpiryTime = 0;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }
}
