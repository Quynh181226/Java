package JavaAdvanced.Ss6.Ex1;

public class BookingCounter implements Runnable{
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private boolean reverseOrder;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, boolean reverseOrder) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.reverseOrder = reverseOrder;
    }

    public boolean sellCombo(){
        TicketPool first = roomA;
        TicketPool second = roomB;
        synchronized (first){

            String ticket1 = first.getTicket();

            if(ticket1 == null){
                System.out.println(counterName + ": Hết vé phòng A");
                return false;
            }

            synchronized (second){
                String ticket2 = second.getTicket();

                if(ticket2 == null){
                    first.returnTicket(ticket1);
                    System.out.println(counterName + ": Hết vé phòng B");
                    return false;
                }

                System.out.println(counterName + " bán combo thành công: " + ticket1 + " & " + ticket2);
                return true;
            }
        }
    }

    @Override
    public void run() {

    }
}
