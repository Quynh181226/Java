package JavaAdvancedd.Ss1;

import java.util.Scanner;

//[Khá] Nhập liệu cơ bản và Lưới an toàn
//1. Mục tiêu:
//Hiểu và áp dụng được cấu trúc try-catch-finally để bắt các lỗi phổ biến khi người dùng nhập liệu.
//2. Mô tả:
//Khởi tạo chức năng đăng ký người dùng cơ bản. Hệ thống yêu cầu người dùng nhập năm sinh từ bàn phím dưới dạng chuỗi (String), sau đó chuyển đổi sang số nguyên (int) để tính tuổi.
//Yêu cầu:
//Sử dụng khối try để chứa đoạn mã phân tích dữ liệu (parse).
//Sử dụng khối catch để bắt lỗi NumberFormatException nếu người dùng nhập chữ thay vì số, và in ra thông báo lỗi thân thiện.
//Sử dụng khối finally để đóng đối tượng Scanner nhằm giải phóng tài nguyên, kèm theo câu lệnh in ra: "Thực hiện dọn dẹp tài nguyên trong finally...".
//3. Kết quả mong muốn:
//Chương trình không bị crash khi nhập sai (ví dụ nhập "hai mươi"). In ra được thông báo lỗi thân thiện và luôn in ra dòng chữ dọn dẹp tài nguyên ở cuối.
public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        try{
            System.out.print("Nhập năm sinh của bạn: ");
            String yearString = input.nextLine();
            int year = Integer.parseInt(yearString);
            int yearOld = 2026 - year;
            System.out.println("Tuổi của bạn là: " + yearOld);
        }catch(NumberFormatException e){
            System.out.println("Lỗi: ");
        } finally {
            input.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }

}
