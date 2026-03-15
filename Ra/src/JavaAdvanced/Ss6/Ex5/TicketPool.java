package JavaAdvanced.Ss6.Ex5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int nextTicketNumber = 1;

    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;

        for (int i = 0; i < capacity; i++) {
            tickets.add(new Ticket(generateTicketId()));
        }
    }

    private String generateTicketId() {
        return roomName + "-" + String.format("%03d", nextTicketNumber++);
    }

    public synchronized Ticket holdTicket(boolean isVIP) {

        for (Ticket t : tickets) {

            if (!t.isHeld()) {

                long expiry = System.currentTimeMillis() + 5000;

                t.hold(expiry);
                t.setVIP(isVIP);

                return t;
            }
        }

        return null;
    }

    public synchronized boolean sellHeldTicket(Ticket ticket) {

        if (ticket != null && ticket.isHeld()) {
            tickets.remove(ticket);
            return true;
        }

        return false;
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld() && now > t.getHoldExpiryTime()) {

                System.out.println("TimeoutManager: Vé " + t.getId() + " hết hạn giữ, đã trả lại kho");

                t.release();
            }
        }
    }

    public String getRoomName() {
        return roomName;
    }
}
