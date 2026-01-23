package Pratice1;
//Cho so nguyen duong n
//Hay tinh S=1+2+...+n
//Du lieu dau vao :
//Dong dau tien ghi so bo test ko qua 10
//Moi dong ghi 1 so nguyen duong n ko qua 10^9
//Kqua:
//Voi moi test ghi ket qua tren 1 dong
//In-Out: 2                55
//        10               210
//        20

import java.util.Scanner;

public class Tong_n_so_nguyen_duong_dau_tien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int s = 0;
            for (int j = 1; j <= n; j++) {
                s += j;
            }
            System.out.println(s);
        }
    }

}
