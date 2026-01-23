package Pratice2;

import java.util.*;

//Một số được coi là đẹp nếu đó là số thuận nghịch và chỉ toàn các chữ số chẵn. Viết chương trình đọc vào các số nguyên dương có không quá 500 chữ số và kiếm tra xem số đó có đẹp hay không.
//Dữ liệu vào:
//Dòng đầu tiên ghi số bộ test.
//Mỗi bộ test viết trên một dòng số nguyên dương n không quá 500 chữ số.
//Kết quả:
//Mỗi bộ test viết ra trên một dòng chữ YES nếu đó là số đẹp, chữ NO nếu ngược lại
//Ví dụ
//Input
//
//4
//
//123456787654321
//
//86442824468
//
//8006000444422220000222244440006008
//
//235365789787654324567856578654356786556
//
//Output
//
//NO
//
//YES
//
//YES
//
//NO
public class soDep {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t=Integer.parseInt(sc.nextLine());
    while(t-->0){
        String s=sc.nextLine();
        boolean check=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)%2==1){
                check=false;
                break;
            }
        }
        String rev= new StringBuilder(s).reverse().toString();
        if(rev.equals(s)&&check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

}
}
