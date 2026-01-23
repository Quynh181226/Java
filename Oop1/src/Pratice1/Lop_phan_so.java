package Pratice1;
//Bai 3: Lop phan so
//Viết chương trình khai báo lớp Phân số gồm hai thuộc tính private là tử số và mẫu số.
//Các giá trị đều nguyên dương và không quá 18 chữ số.
//Sau đó thực hiện nhập vào một phân số và in ra phân số đó ở dạng tối giản.
//Input
//Có hai số nguyên dương lần lượt là tử số và mẫu số.
//Output
//Ghi ra phân số tối giản như trong ví dụ
//Ví dụ
//Input: 123 456
//Output: 41/152
import java.util.Scanner;
class Fraction {

    private long a, b;

    Fraction() {
        a = 0;
        b = 1;
    }

    Fraction(long a, long b) {
        this.a = a;
        this.b = b;
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long z = x % y;
            x = y;
            y = z;
        }
        return x;
    }

    @Override
    public String toString() {
        long g = gcd(this.a, this.b);
        return a / g + "/" + b / g;
    }
}
public class Lop_phan_so {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Fraction f = new Fraction(a, b);
        System.out.println(f);
    }
}
