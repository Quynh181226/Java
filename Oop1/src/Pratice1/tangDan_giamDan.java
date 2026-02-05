package Pratice1;

import java.util.Arrays;
import java.util.Scanner;

//Cho dãy số A[] có N phần tử đều là các số nguyên dương và không quá 1000.
//Hãy liệt kê các số chẵn khác nhau trong dãy theo thứ tự tăng dần và các số lẻ khác nhau trong dãy theo thứ tự giảm dần.
//
//Input
//Dòng đầu ghi số bộ test (không quá 10)
//Mỗi bộ test có hai dòng:
//Dòng đầu ghi số N là số phần tử của dãy (1 < N < 1000)
//Dòng thứ 2 ghi N số trong dãy (các số đều nguyên dương và không quá 1000)
//
//Output
//Với mỗi bộ test, viết ra hai dòng:
//Dòng đầu tiên ghi các số chẵn khác nhau trong dãy theo thứ tự tăng dần
//Dòng thứ hai ghi các số lẻ khác nhau trong dãy theo thứ tự giảm dần
//
//Ví dụ
//Input
//1
//7
//3 7 12 8 5 4 888
//Output
//4 8 12 888
//7 5 3
public class tangDan_giamDan {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while (t-- > 0) {
        int n=sc.nextInt();
        int a[] =new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                if (i == 0 || a[i] != a[i - 1]) {
                    System.out.print(a[i] + " ");
                }
            }
        }
        System.out.println();

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] % 2 == 1) {
                if (i == n - 1 || a[i] != a[i + 1]) {
                    System.out.print(a[i] + " ");
                }
            }
        }
        System.out.println();
        }
    }
}
