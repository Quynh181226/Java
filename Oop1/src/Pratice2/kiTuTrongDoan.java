package Pratice2;

import java.util.Scanner;
//tinh tong cua ki tu trg doan
public class kiTuTrongDoan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int sum=0;
        for(char x: s.toCharArray()){
            if(Character.isDigit(x)){
                sum+=x-'0';
            }
        }
        System.out.println(sum);
//        Scanner sc = new Scanner(System.in);
//        String s=sc.nextLine();
//        int cnt=0;
//        for(int i=0;i<s.length();i++){
//            if(Character.isDigit(s.charAt(i))){
//                cnt+=s.charAt(i)-'0';
//            }
//        }
//        System.out.println(cnt);
    }
}
