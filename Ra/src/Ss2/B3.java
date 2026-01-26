package Ss2;

import java.util.Scanner;

//Độc giả trả muộn $n$ cuốn sách. Mỗi cuốn có số ngày trễ khác nhau. Tiền phạt mỗi ngày là 5.000 VNĐ/cuốn
//
//Yêu cầu:
//Nhập số lượng sách trả muộn n
//Sử dụng vòng lặp for chạy từ 1 đến n
//Trong mỗi lần lặp: Nhập số ngày trễ của cuốn sách thứ i
//Cộng dồn vào biến total
//Kết thúc vòng lặp, in ra tổng số tiền phạt cuối cùng
public class B3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số lượng sách trả muộn: ");
        int n = input.nextInt();

        int total = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập số ngày trễ của cuốn sách thứ " + i + ": ");
            int lateDay = input.nextInt();
            total += lateDay*5000;
        }

        System.out.println("===> Tổng số tiền phạt: " + total + " VNĐ");
    }
}
