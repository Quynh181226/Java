package Pratice3;

import java.util.Scanner;
//Tính tổng phân thức 2
//Nhập số nguyên dương N (1 < N < 10000).
//
//Viết chương trình tính tổng:
//S = 1 - 1/3 + 1/5 - ... +(-) 1/N nếu N lẻ
//S = 1/2 - 1/4 + 1/6 - ... +(-) 1/N nếu N chẵn
//
//Kết quả được in ra với 5 chữ số phần thập phân.
//Input
//Dòng đầu ghi số bộ test, không quá 10.
//Mỗi test ghi một số N
//Output
//Với mỗi bộ test, ghi ra kết quả trên một dòng.
//Ví dụ
//Input	        Output
//2
//2             0.50000
//3	            0.66667

public class tinhTongPhanThuc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Đọc số lượng test case

        while (t-- > 0) {
            int n = sc.nextInt();  // Đọc giá trị n
            double ans = 0.0;

            int start;
            if (n % 2 == 0) {
                start = 2;  // Nếu n chẵn, bắt đầu từ 2
            } else {
                start = 1;  // Nếu n lẻ, bắt đầu từ 1
            }

            for (int i = start; i <= n; i += 2) {
                // Kiểm tra theo quy luật i % 4
                if (i % 4 == 1 || i % 4 == 2) {
                    ans += 1.0 / i;
                } else {
                    ans -= 1.0 / i;
                }
            }

            // In kết quả với 5 chữ số sau dấu thập phân
            System.out.printf("%.5f%n", ans);
        }
    }
}
