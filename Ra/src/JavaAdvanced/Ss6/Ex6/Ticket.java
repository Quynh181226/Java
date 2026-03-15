package JavaAdvanced.Ss6.Ex6;

public class Ticket {

    private String id;
    private boolean sold = false;

    public Ticket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isSold() {
        return sold;
    }

    public void sell() {
        sold = true;
    }
}
