package Ss1;

import java.util.Scanner;

//Xây dựng module tính tiền phạt cho độc giả trả sách quá hạn dựa trên số ngày và loại đối tượng
//
//Yêu cầu:
//
//Nhập số ngày chậm trễ (n) và số lượng sách mượn (m).
//Tính tiền phạt theo công thức: Total = n *  m * 5000
//Sử dụng toán tử logic để kiểm tra điều kiện đặc biệt:
//Nếu n > 7 và m ≥ 3: Tăng thêm 20% tổng tiền phạt (phạt do mượn nhiều mà trả quá muộn).
//Sử dụng toán tử so sánh để in ra thông báo: true nếu tiền phạt > 50,000đ (Yêu cầu khóa thẻ), false nếu ngược lại
public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số ngày chậm chễ: ");
        int n = sc.nextInt();

        System.out.print("Nhập số lượng sách mượn: ");
        int m = sc.nextInt();

        double Total = n *  m * 5000;

        if(n > 7 && m >=3){
            Total*=1.2;
        }

        boolean lockCard=Total>50000;

        System.out.println("\n--- KẾT QUẢ TÍNH TIỀN PHẠT ---");
        System.out.println("Số ngày trễ     : " + n);
        System.out.println("Số sách mượn    : " + m);
        System.out.printf("Tổng tiền phạt   : %.0f VNĐ %n", Total);
        System.out.println("Yêu cầu khóa thẻ: " + lockCard);
    }
}
