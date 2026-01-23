package Pratice1;

import java.util.Scanner;

//TỔNG GIAI THỪA
//Viết chương trình tính tổng S = 1 + 1.2 + 1.2.3 +...+1.2.3...n
//Input: 3
//Output: 9
//Dữ liệu vào: chỉ có một dòng ghi số n không quá 20
//Kết quả: cũng được ghi trên một dòng duy nhất
//Giới hạn thời gian: 2s
//Giới hạn bộ nhớ: 65536 Kb
public class Tong_giai_thua {
public  static void main(String[] args) {
    //Nhap du lieu
    Scanner sc = new Scanner(System.in);
    //Nhap n 
    int n = sc.nextInt();
    //Khai bao mang f chua giai thua cua n so tu 1 den 20 
    long[] f = new long[21];
    //Gan gia tri cho f 
    f[1] = 1;
    for (int i = 2; i <= 20; i++) {
        //Tinh giai thua cua i 
        f[i] = f[i - 1] * i;
    }
    //Khai bao bien res chua ket qua
    long res = 0;
    //Duyet tu 1 den n 
    for (int i = 1; i <= n; i++) {
        //Tinh tong giai thua
        res += f[i];
    }
    //In ra ket qua
    System.out.println(res);
}
}
