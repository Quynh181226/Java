package Ss3;

import java.util.ArrayList;

public class B6 {
    public static void main(String[] args) {
        int[] khoCu = {101, 103, 105, 102};
        int[] loMoi = {102, 104, 101, 106};
        mergeBooks(khoCu, loMoi);
    }

    public static void mergeBooks(int[] a, int[] b) {
        System.out.print("Kho cũ: ");
        for (int x : a) System.out.printf("%d ", x);
        System.out.print("\nLô mới: ");
        for (int x : b) System.out.printf("%d ", x);

        //merge
        ArrayList<Integer> merged = new ArrayList<>();
        for (int x : a) merged.add(x);
        for (int x : b) merged.add(x);

        //dup
        for (int i = 0; i < merged.size(); i++) {
            for (int j = i + 1; j < merged.size(); j++) {
                if (merged.get(i).equals(merged.get(j))) {
                    merged.remove(j);
                    j--;
                }
            }
        }
        //sort
        for (int i = 0; i < merged.size() - 1; i++) {
            for (int j = 0; j < merged.size() - 1 - i; j++) {
                if (merged.get(j + 1) < merged.get(j)) {
                    int temp = merged.get(j);
                    merged.set(j, merged.get(j + 1));
                    merged.set(j + 1, temp);
                }
            }
        }

        //print
        System.out.print("\nKho tổng (đã lọc trùng & sắp xếp): ");
        for (int x : merged) System.out.printf("%d ", x);
    }
}