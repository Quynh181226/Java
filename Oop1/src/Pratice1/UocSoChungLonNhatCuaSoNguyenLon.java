package Pratice1;
import java.math.BigInteger;
import java.util.Scanner;

//O1006
//Cho hai số a và b trong đó a≤1012, b≤10250. Nhiệm vụ của bạn là tìm ước số chung lớn nhất của hai số a, b.
//
//Input:
//Dòng đầu tiên đưa vào T là số lượng bộ test.
//T dòng tiếp đưa các bộ test. Mỗi bộ test gồm hai dòng: dòng đầu tiên đưa vào số a; dòng tiếp theo đưa vào số b.
//Các số T, a, b thỏa mãn ràng buộc: 1≤T≤100; 1≤a≤1012; 1≤b≤10250;
//
//Output:
//Đưa ra kết quả mỗi test theo từng dòng.
//
//Ví dụ:
//Input	Output
//1       1221
//        1234567891011121314151617181920212223242526272829
//        3
public class UocSoChungLonNhatCuaSoNguyenLon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            System.out.println(a.gcd(b));
        }
    }
}




