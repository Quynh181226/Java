package Pratice1;

//import java.util.Scanner;
import java.math.BigInteger;
import java.util.*;

public class chiaHet {
//    Cho hai số nguyên dương a và b không quá 500 chữ số. Hãy kiểm tra xem a chia hết cho b hoặc b chia hết cho a hay không.
//    Input
//    Dòng đầu ghi số bộ test
//    Mỗi bộ test viết trên 1 dòng hai số nguyên dương, cách nhau một khoảng trống. Mỗi số có không quá 500 chữ số.
//    Output
//    Với mỗi test, ghi ra YES hoặc NO theo kết quả kiểm tra.
//    Ví dụ
//    Input
//        2
//        18 7
//        3 123
//    Output
//        NO
//        YES

//a.mod(b) → phép chia dư a % b cho số lớn (BigInteger)
//.intValue() → chuyển kết quả từ BigInteger thành int để so sánh
//== 0 → tức là chia hết
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            //đây là đối tg kiểu BigInteger -> để so sánh == phải chuyển về kiểu nguyên thủy như int, long -> intValue()
            BigInteger a=sc.nextBigInteger(), b=sc.nextBigInteger();
            if(a.mod(b).intValue()==0 || b.mod(a).intValue()==0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
