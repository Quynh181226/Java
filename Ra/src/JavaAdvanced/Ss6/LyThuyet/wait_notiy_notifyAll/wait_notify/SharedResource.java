package JavaAdvanced.Ss6.LyThuyet.wait_notiy_notifyAll.wait_notify;

public class SharedResource {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value){
        try{
            while(hasData){
                wait();
            }

            data = value;
            System.out.println("Producer tạo: " + data);

            hasData = true;

            notify();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            while (!hasData) {
                wait(); // Chờ producer tạo dữ liệu
            }

            System.out.println("Consumer lấy: " + data);

            hasData = false;

            notify(); // báo producer tiếp tục
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
