package JavaCore.Ss12.HN_K24_CNTT2_PhamHuongQuynh_005;

import java.util.Scanner;

//Tong day con lien tiep lon nhat - Kadane's Algorithm
//Cho 1 mang so nguyen A(bao gom ca so am va so duong)
//Hay tim 1 day con lien tiep(it nhat 1 phtu) co tong cac phtu lon nhat va in ra tong do
public class Ex2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //Res
        System.out.println(maxSubSum(arr));
    }

    public static int maxSubSum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxSum = arr[0];
        int currSum  = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }
}