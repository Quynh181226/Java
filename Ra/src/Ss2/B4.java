package Ss2;

import java.util.Scanner;

//Khi nhập mã ID sách mới, ID phải là số nguyên dương (ID > 0). Nếu nhập sai, chương trình bắt nhập lại
//
//Yêu cầu:
//Đặt lệnh nhập ID bên trong thân vòng lặp do
//Điều kiện của while là ID <= 0
//Chừng nào người dùng còn nhập số âm hoặc số 0, thông báo "Mã không hợp lệ, hãy nhập lại" và quay lại bước 1
//Khi nhập đúng, thoát vòng lặp và thông báo "Lưu mã sách thành công"
public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id;

        do {
            System.out.print("Nhập mã sách: ");
            id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Mã không hợp lệ, hãy nhập lại");
            }
        } while (id <= 0);

        System.out.println("Lưu mã sách thành công");
    }
}