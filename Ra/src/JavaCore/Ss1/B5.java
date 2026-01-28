package JavaCore.Ss1;

import java.util.Scanner;

//Để tránh việc thủ thư nhập sai mã sách, thư viện sử dụng một loại mã 4 chữ số có "Số kiểm tra" (Check-digit). Chữ số cuối cùng phải bằng Tổng của 3 chữ số đầu tiên chia lấy dư cho 10
//
//Yêu cầu:
//Cho sinh viên nhập vào một số nguyên 4 chữ số (Ví dụ: 1236)
//Tách số đó thành 4 phần riêng biệt: thousands, hundreds, dozens, units
//Thực hiện logic kiểm tra:
//Tính sumOfFirstThreeNumber = thousands + hundreds + dozens
//Số dư của sumOfFirstThreeNumber % 10 phải bằng donVi
//Sử dụng toán tử logic để in ra thông báo: true nếu mã hợp lệ, false nếu mã sai
//Thử thách: Thực hiện toàn bộ logic tách số mà không dùng chuỗi (String), chỉ dùng toán tử số học
public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách (4 chữ số): ");
        int n = sc.nextInt();

        System.out.print("Chữ số kiểm tra kỳ vọng: ");
        int exp=sc.nextInt();

        int t=n/1000, h=(n/100)%10, d=(n/10)%10, u=n%10, sum=t+h+d;
        boolean check= (sum%10==exp);

        System.out.print("Kết quả kiểm tra mã sách: "+(check? "Sai mã": "Hợp lệ"));
    }
}
