package Pratice1;
// TÍNH SỐ FIBONACCI
// Dãy số Fibonacci được định nghĩa theo công thức như sau:
// F₁ = 1
// F₂ = 1
// Fₙ = Fₙ₋₁ + Fₙ₋₂ với n > 2
// Viết chương trình tính số Fibonacci thứ n (với n không quá 92)

// Input:
// - Dòng đầu ghi số bộ test.
// - Mỗi bộ test là một số nguyên n.

// Output:
// - Với mỗi bộ test, ghi ra số Fibonacci thứ n trên một dòng.

//Eg:
// Input:
// 3
// 2
// 5
// 20

// Output:
// 1
// 5
// 6765

// Giới hạn thời gian: 2s
// Giới hạn bộ nhớ: 65536 Kb

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long [] f=new long[93];
        f[1]=f[2]=1L;
        for(int i=3;i<=92;i++){
            f[i]=f[i-1]+f[i-2];
        }
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            System.out.println(f[n]);
        }
    }
}