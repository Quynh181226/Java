package JavaCore.Ss10;
//[Bài tập] Điều khiển Thiết bị thông minh với Anonymous Class
//
//1. Mục tiêu
//Sử dụng Anonymous Class để triển khai nhanh một giao diện điều khiển mà không cần tạo file lớp mới.
//Áp dụng kiến thức về Default Method (Java 8+) để mở rộng tính năng interface.
//2. Mô tả Hệ thống điều khiển nhà thông minh cần thêm nhanh một thiết bị "Đèn cảm ứng" vào danh sách quản lý.
//Yêu cầu:
//Tạo interface RemoteControl có phương thức void powerOn().
//Thêm một default method là void checkBattery() in ra "Pin ổn định".
//Trong hàm main, dùng Anonymous Class để tạo đối tượng smartLight từ RemoteControl, thực thi powerOn() in ra "Đèn đã bật".
//3. Kết quả mong muốn
//Thiết bị nặc danh hoạt động đúng các phương thức powerOn và checkBattery ngay trong hàm main.
public class B4 {
    interface RemoteControl{
        void powerOn();

        default void checkBattery(){
            System.out.println("Pin ổn định");
        }
    }
}
