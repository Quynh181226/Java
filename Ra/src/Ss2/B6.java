package Ss2;

import java.util.Scanner;

//Thủ thư muốn thống kê trong một tuần (7 ngày), ngày nào có lượt mượn sách cao nhất và ngày nào thấp nhất để điều phối nhân sự
//
//Yêu cầu:
//Sử dụng vòng lặp for chạy 7 lần (tương ứng từ Thứ 2 đến Chủ Nhật).
//Mỗi lần lặp, nhập số lượt mượn sách của ngày đó
//Sử dụng kỹ thuật đặt "biến tạm" để tìm ra số lượt mượn lớn nhất và nhỏ nhất mà không dùng mảng
//Nếu ngày nào có số lượt mượn bằng 0, sử dụng continue để không tính ngày đó vào thống kê trung bình (vì có thể là ngày thư viện đóng cửa)
//In ra: Lượt mượn cao nhất, thấp nhất và trung bình của các ngày có mở cửa
public class B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int min = -1;
        int total = 0;
        int count = 0;

        for (int i = 1; i <= 7; i++) {
            if (i == 7) {
                System.out.print("Nhap luot muon ngay Chu nhat: ");
            } else {
                System.out.printf("Nhap luot muon ngay Thu %d: ", i + 1);
            }

            int val = sc.nextInt();

            if (val == 0) continue;

            total += val;
            count++;

            if (max == -1) {
                max = val;
                min = val;
            }

            if (val > max) max = val;
            if (val < min) min = val;
        }

        System.out.println("---Ket qua thong ke---");

        if (count == 0) {
            System.out.println("Khong co ngay nao mo cua");
        } else {
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.printf("Trung binh luot muon/ngay: %.1f\n", (double) total / count);
        }

        sc.close();
    }
}