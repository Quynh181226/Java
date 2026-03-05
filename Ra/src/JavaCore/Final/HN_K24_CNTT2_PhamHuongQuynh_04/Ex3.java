package JavaCore.Final.HN_K24_CNTT2_PhamHuongQuynh_04;

import java.util.Scanner;
import java.util.Stack;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Loi: So khong hop le");
            return;
        }


        if (n == 0) {
            System.out.println("0");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int i = n % 2;
            stack.push(i);
            n = n / 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println();
    }
}