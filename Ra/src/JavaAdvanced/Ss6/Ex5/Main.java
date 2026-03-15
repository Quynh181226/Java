package JavaAdvanced.Ss6.Ex5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);
        TicketPool roomC = new TicketPool("C", 5);

        Thread c1 = new Thread(new BookingCounter("Quầy 1", roomA));
        Thread c2 = new Thread(new BookingCounter("Quầy 2", roomA));
        Thread c3 = new Thread(new BookingCounter("Quầy 3", roomB));
        Thread c4 = new Thread(new BookingCounter("Quầy 4", roomB));
        Thread c5 = new Thread(new BookingCounter("Quầy 5", roomC));

        TimeoutManager manager =
                new TimeoutManager(Arrays.asList(roomA, roomB, roomC));

        Thread timeoutThread = new Thread(manager);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        timeoutThread.start();
    }
}
