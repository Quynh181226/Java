package Ss2;

import java.util.Scanner;

//2. Mô tả
//Bạn cần viết một chương trình cho phép thủ thư thực hiện 3 chức năng chính: tính tiền phạt trả muộn, kiểm tra điều kiện mượn sách đặc biệt, và thống kê nhanh hiệu suất ngày làm việc
//
//3. Bài tập thực hành
//Chức năng 1: Tính tiền phạt trả sách (Sử dụng For)
//Yêu cầu nhập số lượng sách độc giả trả
//Với mỗi cuốn, nhập số ngày quá hạn
//Công thức: * Trễ từ 1 - 5 ngày: 2.000 VNĐ/ngày
//Trễ trên 5 ngày: 5.000 VNĐ/ngày (cho các ngày từ ngày thứ 6 trở đi)
//In ra tổng tiền phạt của độc giả đó
//
//Chức năng 2: Đăng ký thẻ mượn sách VIP (Sử dụng If-Else & Toán tử điều kiện)
//Nhập tuổi và số sách đã mượn trong tháng qua
//Điều kiện VIP: Tuổi >= 18 và đã mượn >= 10 cuốn sách, HOẶC là sinh viên có thẻ ưu tiên (nhập 1 là có, 0 là không)
//In ra kết quả "Đủ tiêu chuẩn nâng cấp VIP" hoặc "Chưa đủ tiêu chuẩn"
//
//Chức năng 3: Thống kê số sách nhập kho (Sử dụng Do-While & Break/Continue)
//Thủ thư nhập mã số các cuốn sách mới về kho
//Nếu nhập mã số âm: Yêu cầu nhập lại (Sử dụng continue)
//Nếu nhập mã số 0: Dừng việc nhập kho (Sử dụng break)
//Sau khi kết thúc, in ra tổng số lượng sách hợp lệ đã nhập vào
public class Btth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n=== QUAN LY THU VIEN ===");
            System.out.println("1. Tinh phat muon");
            System.out.println("2. Dang ky VIP");
            System.out.println("3. Thong ke sach moi");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();

            switch (chon) {
                case 1: phatMuon(sc); break;
                case 2: vip(sc); break;
                case 3: sachMoi(sc); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Sai, chon lai.");
            }
        } while (chon != 0);

        sc.close();
    }

    static void phatMuon(Scanner sc) {
        System.out.print("So luong sach: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Khong hop le.");
            return;
        }

        long fine = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Ngay qua han sach " + i + ": ");
            int day = sc.nextInt();
            if (day <= 0) continue;

            if (day <= 5) fine += day * 2000L;
            else fine += 5 * 2000L + (day - 5) * 5000L;
        }
        System.out.println("Tong phat: " + fine + " VND");
    }

    static void vip(Scanner sc) {
        System.out.print("Tuoi: ");
        int age = sc.nextInt();
        System.out.print("So sach muon thang qua: ");
        int books = sc.nextInt();
        System.out.print("The uu tien SV (1=Có, 0=Không): ");
        int vipCard = sc.nextInt();

        boolean ok = (age >= 18 && books >= 10) || vipCard == 1;
        System.out.println(ok ? "Du dieu kien VIP!" : "Chua du dieu kien.");
    }

    static void sachMoi(Scanner sc) {
        int cnt = 0;
        int code;

        System.out.println("Nhap ma sach moi (0=ket thuc, am=nhap lai)");

        do {
            System.out.print("Ma sach: ");
            code = sc.nextInt();

            if (code < 0) continue;
            if (code == 0) break;

            cnt++;
        } while (true);

        System.out.println("Tong sach hop le: " + cnt + " cuon");
    }
}