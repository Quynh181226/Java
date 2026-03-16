package JavaAdvanced.Ss6.LyThuyet.wait_notiy_notifyAll.notifyAll;


public class NotifyAllExample {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        Thread c1 = new Thread(() -> queue.consume("Consumer 1"));
        Thread c2 = new Thread(() -> queue.consume("Consumer 2"));
        Thread c3 = new Thread(() -> queue.consume("Consumer 3"));

        c1.start();
        c2.start();
        c3.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e){
        }

        new Thread(queue::produce).start();
    }
}
