package JavaAdvanced.Ss6.Ex5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool pool;
    private Random random = new Random();

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            boolean vip = random.nextBoolean();

            Ticket ticket = pool.holdTicket(vip);

            if (ticket != null) {

                System.out.println(name + ": Đã giữ vé " + ticket.getId()
                        + (vip ? " (VIP)" : "")
                        + ". Vui lòng thanh toán trong 5s");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    return;
                }

                boolean success = pool.sellHeldTicket(ticket);

                if (success) {
                    System.out.println(name + ": Thanh toán thành công vé " + ticket.getId());
                }

            } else {

                System.out.println(name + ": Không còn vé trong phòng " + pool.getRoomName());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
