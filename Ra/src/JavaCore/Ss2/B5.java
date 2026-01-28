package JavaCore.Ss2;
import java.util.Scanner;
//Thư viện muốn đánh giá độ uy tín của độc giả dựa trên lịch sử trả sách. Mỗi lần trả đúng hạn được cộng điểm, trả muộn bị trừ điểm. Độc giả sẽ nhập lịch sử cho đến khi nhập số 0 để kết thúc
//
//Yêu cầu:
//Khởi tạo điểm uy tín ban đầu là 100
//Sử dụng vòng lặp while để nhập số ngày trễ của từng lần trả sách (Số dương: trễ hạn, Số âm hoặc bằng 0: đúng hạn/sớm hạn)
//Quy tắc: * Nếu trả đúng hạn (nhập số <= 0): Cộng 5 điểm
//Nếu trả muộn (nhập số > 0): Trừ (số ngày trễ x 2) điểm
//Vòng lặp dừng lại khi người dùng nhập số 999 (Mã thoát)
//In ra tổng điểm uy tín cuối cùng và xếp loại:
//Trên 120: Độc giả Thân thiết
//Từ 80 - 120: Độc giả Tiêu chuẩn
//Dưới 80: Độc giả cần lưu ý
public class B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 100;

        System.out.println("--- HE THONG DANH GIA DOC GIA ---");
        System.out.println("(Nhap so ngay tre. Nhap 999 de ket thuc)");

        while (true) {
            System.out.print("So ngay tre cua lan nay: ");
            int daysLate = sc.nextInt();

            if (daysLate == 999) break;

            if (daysLate <= 0) {
                score += 5;
            } else {
                int penalty = daysLate * 2;
                score -= penalty;
                System.out.println("-> Tra tre " + daysLate + " ngay: -" + penalty + " diem.");
            }
        }

        System.out.println("\nTong diem uy tin: " + score);

        if (score > 120) {
            System.out.println("Xep loai: DOC GIA THAN THIET");
        } else if (score >= 80) {
            System.out.println("Xep loai: DOC GIA TIEU CHUAN");
        } else {
            System.out.println("Xep loai: DOC GIA CAN LUU Y");
        }

        sc.close();
    }
}