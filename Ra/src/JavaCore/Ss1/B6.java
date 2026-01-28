package JavaCore.Ss1;

import java.util.Scanner;

//Thư viện có một kho sách lớn. Mỗi kệ sách có thể chứa tối đa 25 cuốn. Kệ được đánh số theo khu vực (Khu A, Khu B...) dựa trên mã số thứ tự của sách
//
//Yêu cầu:
//Nhập vào số thứ tự của cuốn sách mới (int stt)
//Xác định số thứ tự của Kệ sách mà cuốn sách đó sẽ thuộc về (Ví dụ: Sách từ 1-25 thuộc kệ 1, 26-50 thuộc kệ 2...)
//Xác định Vị trí chính xác của cuốn sách đó trên kệ đó (từ 1 đến 25)
//Xác định khu vực: Nếu kệ từ 1-10 là "Khu Cận", trên 10 là "Khu Viễn"
//Yêu cầu kỹ thuật: Sử dụng toán tử điều kiện ? : để in ra địa chỉ lưu kho hoàn chỉnh dưới dạng: Kệ số X - Vị trí Y - Khu vực Z
public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự sách: ");
        int stt = sc.nextInt();

        int shelf = (stt - 1) / 25 + 1;
        int pos = (stt - 1) % 25 + 1;
        String area = (shelf <= 10) ? "Khu Cận (Gần cửa)" : "Khu Viễn (Xa cửa)";

        System.out.print("--- Thông tin định vị ---\n" +
                         "Sách số: " + pos +
                         "\nKệ số " + shelf + " - Vị trí " + pos +
                         "\nPhân khu: " + area);
    }
}
