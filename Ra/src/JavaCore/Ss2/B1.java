package JavaCore.Ss2;

import java.util.Scanner;

//Thư viện quy định: Để mượn sách "Quý hiếm", bạn phải từ 18 tuổi trở lên và hiện đang mượn ít hơn 3 cuốn sách
//
//Yêu cầu:
//Nhập tuổi (số nguyên) và số sách đang giữ (số nguyên)
//Sử dụng câu lệnh điều kiện để kiểm tra đồng thời hai yếu tố
//Nếu thỏa mãn cả hai: Xuất "Cho phép mượn sách"
//Nếu không: Xuất lý do cụ thể (Ví dụ: "Bạn chưa đủ tuổi" hoặc "Bạn đã mượn quá số lượng cho phép")
public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();

        System.out.print("Nhap so sach dang muon: ");
        int currBooks = sc.nextInt();

        if(age >= 18 && currBooks < 3) {
            System.out.println("Cho phep muon sach");
        } else if (age < 18) {
            System.out.println("Ban chua du tuoi");
        }else if (currBooks > 3) {
            System.out.println("Ban da muon qua so luong cho phep");
        }
    }
}
