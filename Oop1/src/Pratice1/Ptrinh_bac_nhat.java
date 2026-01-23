package Pratice1;
import java.util.Scanner;
// GIẢI PHƯƠNG TRÌNH BẬC NHẤT
// Phương trình bậc nhất là phương trình dạng ax + b = 0.
// Viết chương trình nhập vào hệ số a, b là các số thực và thực hiện giải phương trình bậc nhất.

// Output:
// - Nếu phương trình vô nghiệm thì in ra "VN".
// - Nếu phương trình có vô số nghiệm thì in ra "VSN".
// - Nếu phương trình có nghiệm duy nhất thì in ra với định dạng luôn 2 chữ số thập phân.
// Input:
// - Chỉ có hai số thực a và b.

// Example:
// Input:
// 2 -1
// Output:
// 0.50

public class Ptrinh_bac_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a=sc.nextFloat();
        float b=sc.nextFloat();
        if(a==0f){
            if(b==0f){
                System.out.println("VN");
            }else{
                System.out.println("VSN");
            }
        }else{
            System.out.printf("%.2f",-b/a);
        }
    }
}
