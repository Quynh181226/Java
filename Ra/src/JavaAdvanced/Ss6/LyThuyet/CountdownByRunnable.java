package JavaAdvanced.Ss6.LyThuyet;

public class CountdownByRunnable implements Runnable{
    private int start;

    public CountdownByRunnable(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        for(int i = start; i > 0; i--){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Tạm dừng 1 giây giữa mỗi lần đếm
            } catch (InterruptedException e) {
                System.out.println("Countdown interrupted");
                return;
            }
        }
        System.out.println("Countdown finished!");
    }

    public static void main(String[] args) {
        int countdownFrom = 10;
        CountdownByRunnable countdown = new CountdownByRunnable(countdownFrom);
        Thread thread = new Thread(countdown, "Countdown");
        thread.start();
    }
}
