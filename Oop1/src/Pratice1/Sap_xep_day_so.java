package Pratice1;

import java.util.Arrays;
import java.util.Scanner;

public class Sap_xep_day_so {
    public static void main(String[] args) {
        // Bai 1: Sap xep day so
        // Cho dãy số a[] có n số nguyên dương.
        // Tất cả các số trong dãy đều có đúng 4 chữ số.
        // Hãy sắp xếp dãy số a theo thứ tự tăng dần và in kết quả ra màn hình.
        // Input
        // Dòng đầu ghi số bộ test, không quá 10.
        // Mỗi bộ test:
        // Dòng đầu ghi số n (không quá 1 triệu)
        // Dòng thứ 2 ghi n số của dãy a[]
        // Output
        // Với mỗi bộ test, ghi ra lần lượt các số trong dãy a[] theo đúng thứ tự tăng
        // dần,
        // mỗi số cách nhau 1 khoảng trống.
        // Ví dụ
        // Input
        // 2
        // 4
        // 5 7 1 4
        // 7
        // 123 456 100 989 444 111 90
        // Output
        // 1 4 5 7
        // 90 100 111 123 444 456 989
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            // Sap xep day so tang dan
            Arrays.sort(a);
            // In day so da sap xep
            for (int k = 0; k < n; k++) {
                System.out.print(a[k]);
                if (k < n - 1) {
                    System.out.print(" ");
                }
            }
            // Xuong dong sau moi bo test
            System.out.println();
        }
        sc.close();
    }
}
