package JavaCore.Ss12.HN_K24_CNTT2_PhamHuongQuynh_005;

import java.util.Scanner;

//Nen chuoi co ban
//Nhap vao 1 chuoi chi gom cac chu cai.
//Hay viet ham thuc hien "nen" chuoi bang cach dem so luong ky tu lien tiep giong nhau
public class Ex1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(StrCompress(s));
    }

    //Check -> Loop -> += -> Check res -> Print
    public static String StrCompress(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n <= 1) return s;

        int count = 1;
//      String str="";
//      boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (i < n && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                if (count > 1) sb.append(count);
                count = 1;
//              check = true
            }
//            System.out.print(str);
        }

        if (sb.length() >= n) {
            return s;
        }
        return sb.toString();
    }
}

