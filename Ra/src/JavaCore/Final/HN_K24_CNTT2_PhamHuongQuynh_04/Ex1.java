package JavaCore.Final.HN_K24_CNTT2_PhamHuongQuynh_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Loi: So luong khong hop le");
            return;
        }

        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                names.add(name);
            }
        }

        String longestName = "";
        int max = -1;
        for (String name : names) {
            if (name.length() > max) {
                max = name.length();
                longestName = name;
            }
        }

        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted);

        int cnt = 0;
        for (String name : names) {
            if (name.toUpperCase().startsWith("A")) {
                cnt++;
            }
        }

        System.out.println("Longest name: " + longestName);
        System.out.print("Sorted list: ");
        boolean one = true;
        for (String name : sorted) {
            if (!one) {
                System.out.print(" ");
            }
            System.out.print(name);
            one = false;
        }
        System.out.println();
        System.out.println("Number of names starting with A: " + cnt);
    }
}