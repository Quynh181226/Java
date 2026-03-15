package JavaAdvanced.Ss6.Ex6;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool pool;
    private volatile boolean running = true;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {

                System.out.println(name + " bán vé " + ticket.getId());

            } else {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }
}
