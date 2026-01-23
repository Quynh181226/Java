package Ss1;

//Viết chương trình cho phép thủ thư nhập thông tin cho một cuốn sách mới nhập kho và in ra phiếu thông tin định dạng rõ ràng
//
//Yêu cầu:
//Khai báo và nhập từ bàn phím các biến:
//bookID (String)
//bookName (String)
//publishYear (int)
//price (double)
//isAvailable (boolean)
//Tính "Tuổi thọ sách" = 2026 - publishYear
//Xuất dữ liệu ra màn hình theo định dạng:
//Tên sách viết hoa toàn bộ
//Giá tiền hiển thị 2 số thập phân
//Thông báo tình trạng: "Còn sách" nếu isAvailable là true, ngược lại "Đã mượn"

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Nhập mã sách: ");
        String bookId = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear = sc.nextInt();

        System.out.print("Nhập giá bìa: ");
        double price = sc.nextDouble();

        System.out.print("Sách còn trong kho (true/false): ");
        boolean isAvailable = sc.nextBoolean();

        int bookAge=2026-publishYear;
        String status=isAvailable ? "Còn sách": "Đã mượn";

        System.out.println("\n--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Tên sách   : "+bookName);
        System.out.println("Mã số   : "+bookId+" | Tuổi thọ: "+bookAge+" năm");
        System.out.printf("Giá bán:  %.2f VNĐ%n", price);
        System.out.println("Tình trạng: "+status);
    }
}
