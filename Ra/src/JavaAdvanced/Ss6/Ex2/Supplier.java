package JavaAdvanced.Ss6.Ex2;

public class Supplier implements Runnable{
    private TicketPool pool;

    public Supplier(TicketPool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            pool.addTickets(3);
        }
    }
}
