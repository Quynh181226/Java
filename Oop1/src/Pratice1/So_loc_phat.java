package Pratice1;

import java.util.Scanner;

public class So_loc_phat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(s.length() >= 2 && s.substring(s.length() - 2).equals("86") ? "YES" : "NO");
        }
    }
}
//saiii