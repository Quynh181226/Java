package JavaAdvanced.Ss6.LyThuyet;

public class CountdownByThreadClass extends Thread {
    private int count;

    public CountdownByThreadClass(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("Countdown: " + count);
            count--;

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
        CountdownByThreadClass countdown = new CountdownByThreadClass(10);
        countdown.start();
    }
}
