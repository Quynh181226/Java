package JavaAdvanced.Ss6.Ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CinemaSimulation {

    private List<TicketPool> rooms = new ArrayList<>();
    private List<BookingCounter> counters = new ArrayList<>();

    private ExecutorService executor;

    public void start(int roomCount, int ticketsPerRoom, int counterCount) {

        rooms.clear();
        counters.clear();

        for (int i = 0; i < roomCount; i++) {

            char name = (char) ('A' + i);

            rooms.add(new TicketPool(String.valueOf(name), ticketsPerRoom));
        }

        executor = Executors.newFixedThreadPool(counterCount);

        for (int i = 0; i < counterCount; i++) {

            TicketPool pool = rooms.get(i % rooms.size());

            BookingCounter counter = new BookingCounter("Quầy " + (i + 1), pool);

            counters.add(counter);

            executor.submit(counter);
        }

        System.out.println("Đã khởi tạo hệ thống với "
                + roomCount + " phòng, "
                + (roomCount * ticketsPerRoom)
                + " vé, "
                + counterCount + " quầy");
    }

    public void stop() {

        for (BookingCounter c : counters) {
            c.stop();
        }

        executor.shutdownNow();

        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void statistics() {

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        for (TicketPool pool : rooms) {

            System.out.println("Phòng " + pool.getRoomName()
                    + ": Đã bán "
                    + pool.soldCount()
                    + "/"
                    + pool.total()
                    + " vé");
        }
    }
}
