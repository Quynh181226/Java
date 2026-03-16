package JavaAdvanced.Ss6.LyThuyet.sleep_join_yield;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Worker thread is running: " + i);
                try {
                    Thread.sleep(1000); // Tạm dừng 1 giây
                } catch (InterruptedException e) {
                    System.out.println("Worker thread was interrupted");
                }
            }
        });

        worker.start();

        worker.join(); // main chờ worker chạy xong

        System.out.println("Main thread tiếp tục chạy");
    }
}
