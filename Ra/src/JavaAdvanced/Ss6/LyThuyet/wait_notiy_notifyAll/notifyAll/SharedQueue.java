package JavaAdvanced.Ss6.LyThuyet.wait_notiy_notifyAll.notifyAll;

public class SharedQueue {
    private boolean available = false;

    public synchronized void produce(){
        System.out.println("Producer tạo dữ liệu");
        available = true;
        notifyAll(); // Thông báo tất cả các thread đang chờ
    }

    public synchronized void consume(String name){
       try{
           while(!available){
               System.out.println(name + " đang chờ dữ liệu...");
               wait(); // Thread sẽ chờ cho đến khi có dữ liệu
           }
           System.out.println(name + " nhận được dữ liệu");
       } catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
