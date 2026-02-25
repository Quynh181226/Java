package JavaCore.Ss12.HN_K24_CNTT2_PhamHuongQuynh_005;

import java.util.Scanner;

//Tim mang con lien tiep co tong bang S
//Cho 1 mang gom cac so nguyen duong arr va 1 so nguyen duong S
//Hay tim mang con lien tiep dau tien sao cho tong cac phtu trong mang con do dung bang S
//In ra vtri (idx) bdau va kthuc cua mang con do. Neu ko tim thay, in ra -1
public class Ex3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int s = sc.nextInt();
        subWithSumS(arr, n, s);
    }

    //start-> end ==> i, j
    //thu hep from i (left)
    public static void subWithSumS(int[] arr, int n, int s) {
        int j = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            while (sum > s && j <= i) {
                sum -= arr[j];
                j++;
            }

            if (sum == s) {
                System.out.println(j + " " + i);
                return;
            }
        }

        System.out.println(-1);
    }
}