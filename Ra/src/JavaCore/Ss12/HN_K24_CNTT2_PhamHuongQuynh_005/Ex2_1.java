package JavaCore.Ss12.HN_K24_CNTT2_PhamHuongQuynh_005;

import java.util.Scanner;

//Dich xoay mang K buoc
//Cho 1 mang so nguyen arr va so nguyen duong k
//Hay dich xoay toan bo phtu cua mang sang ben phai k buoc
public class Ex2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        rotate(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n <= 1 || k == 0) return;

        k = k % n;
        for (int i = 0; i < k; i++) {
            int last = arr[n - 1];

            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[0] = last;
        }
    }

}