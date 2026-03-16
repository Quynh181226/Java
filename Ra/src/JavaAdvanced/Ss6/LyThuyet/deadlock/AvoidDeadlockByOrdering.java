package JavaAdvanced.Ss6.LyThuyet.deadlock;

public class AvoidDeadlockByOrdering {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> acquireLocks(lockA, lockB));
        Thread thread2 = new Thread(() -> acquireLocks(lockA, lockB));

        thread1.start();
        thread2.start();
    }

    private static void acquireLocks(Object lock1, Object lock2){
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Locked lock1");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": Locked lock2");
            }
        }
    }
}
