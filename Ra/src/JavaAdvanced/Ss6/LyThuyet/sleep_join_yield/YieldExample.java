package JavaAdvanced.Ss6.LyThuyet.sleep_join_yield;

public class YieldExample {
    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(getName() + " is running: " + i);
                if (i == 2) {
                    System.out.println(getName() + " is yielding...");
                    Thread.yield(); // Tạm dừng để nhường cơ hội cho thread khác
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread("Thread-1");
        Thread t2 = new MyThread("Thread-2");

        t1.start();
        t2.start();
    }
}
