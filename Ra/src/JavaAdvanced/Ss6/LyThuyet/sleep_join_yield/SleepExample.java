package JavaAdvanced.Ss6.LyThuyet.sleep_join_yield;

public class SleepExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread is running: " + i);
                try {
                    Thread.sleep(1000); // Tạm dừng 1 giây
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });

        t.start();
    }
}
