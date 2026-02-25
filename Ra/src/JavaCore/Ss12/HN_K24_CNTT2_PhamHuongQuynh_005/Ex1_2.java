package JavaCore.Ss12.HN_K24_CNTT2_PhamHuongQuynh_005;

import java.util.Scanner;

//Dao nguoc tu (.) cau
//Cho 1 chuoi chua cac tu cach nhau boi khoang trang.
//Hay dao nguoc thu tu cac ky tu ben (.) tung tu, nhg giu nguyen vtri cua cac tu va khoang trang (.) cau
public class Ex1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        reverseWords(s);
    }

    public static void reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder rev = new StringBuilder(words[i]);
            rev.reverse();
            
            res.append(rev);
            if (i < words.length - 1) {
                res.append(" ");
            }
        }

        System.out.println(res.toString());
    }
}