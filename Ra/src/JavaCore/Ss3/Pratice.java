package JavaCore.Ss3;

import java.util.Scanner;

//Bài tập array
//1.1: Nhập và in mảng
//Thực hiện cho người dùng nhập vào số lượng phần tử mảng n và nhập giá trị cho từng phần tử
//Tiến hành in ra các phần tử trong mảng vừa nhập
//Ví dụ: input: 3 5 7 9
//       output: Mảng vừa nhập: 5 7 9
//1.2: Phát triển bài toán 1.1 thêm các yêu cầu sau:
//-Tìm và in các số nguyên tố trong mảng
//-Tính tổng các số fibo trong mảng
//Tìm min, max trong mảng
//Tính tổng các giai thừa của từng phần tử trong mảng
public class Pratice {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1.1
        System.out.print("Nhập số lg ptu arr: ");
        int n = sc.nextInt();
        int [] arr=new int[n];

        System.out.print("Nhập els: ");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.print("Arr: ");
        for (int i=0;i<n;i++){
            System.out.print(i+" ");
        }
        //1.2
        int min=arr[0], max=arr[0], sum=0;
        long total=0;
        //Prime - haven't or have
        boolean flag=false;
        for (int i=1;i<n;i++){
            if(prime(arr[i])){
                System.out.print(i+" ");
                flag=true;
            }
        }

        if(!flag){
            System.out.println("Haven't prime");
        }

        //total fibo

    }

    public static boolean prime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static boolean fibo(int n) {
        if (n < 0) return false;

        int a = 0, b = 1;
        while (a <= n) {
            if (a == n) return true;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return false;
    }

    public static long factorial(int n) {
        if (n < 0) return 0;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
