package Pratice1;

import java.util.Scanner;

public class danhDauChuCai {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase(); // Đọc cả dòng và chuyển về chữ thường
        int[] dd = new int[127]; // mảng đánh dấu
        for (int i = 0; i < s.length(); i++) {
            dd[s.charAt(i)]++;
        }

        int res = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            if (dd[i] > 0) {
                res++;
            }
        }

        System.out.println(res); // In ra số chữ cái khác nhau
    }
}
