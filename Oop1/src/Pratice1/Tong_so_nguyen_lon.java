package Pratice1;
import java.math.BigInteger;
import java.util.Scanner;

//Cho hai số rất lớn X và Y được biểu diễn như hai xâu ký tự. Nhiệm vụ của bạn là tìm X+Y?
//Input:
//Dòng đầu tiên đưa vào số lượng test T.
//Những dòng kế tiếp đưa vào các bộ test. Mỗi test gồm hai dòng: dòng thứ nhất đưa xâu X; dòng tiếp theo đưa vào xâu Y.
//        T, X, Y thỏa mãn ràng buộc : 1≤T≤100; 0≤length(X), length(Y)≤103.
//Output:
//Đưa ra số kết quả mỗi test theo từng dòng.
//Ví dụ:
//Input:
//        1
//        12
//        198111
//Output:
//        198123
public class Tong_so_nguyen_lon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            //Nhập 2 số nguyên lớn
            //BigInteger là kiểu dữ liệu của Java để lưu trữ số nguyên lớn
            //To
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
}
