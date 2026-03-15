package JavaAdvanced.Ss6.Ex3;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();
    private int ticketNumber = 1;

    public TicketPool(String roomName, int initialTickets) {
        this.roomName = roomName;

        for (int i = 0; i < initialTickets; i++) {
            tickets.add(new Ticket(generateTicketId()));
        }
    }

    private String generateTicketId() {
        return roomName + "-" + String.format("%03d", ticketNumber++);
    }

    public synchronized Ticket sellTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.poll();
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(generateTicketId()));
        }

        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
