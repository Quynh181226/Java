package Pratice2;

import java.util.Scanner;

//cach su dung mang danh dau
public class soLanXuatHienCuaPtu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="1dnwiufh38huhnwfb";
        int[] cnt=new int[256];
        for(char c:s.toCharArray()) cnt[c]++;
        for (int i=0; i<256; i++){
            if (cnt[i]!=0){
                System.out.println((char)i +" "+cnt[i]);
            }
        }
    }
}
