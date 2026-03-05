package JavaCore.Final.HN_K24_CNTT2_PhamHuongQuynh_04;

import java.util.*;

public class Ex2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Loi: So luong phan tu khong hop le");
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }


        List<Integer> sorted = new ArrayList<>();
        for (Integer key : map.keySet()) {
            sorted.add(key);
        }

        Collections.sort(sorted);
        for (int num : sorted) {
            System.out.println(num + " xuat hien " + map.get(num) + " lan");
        }

        int max = 0;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        System.out.print("So xuat hien nhieu nhat: ");
        boolean one = true;
        for (int num : sorted) {
            if (map.get(num) == max) {
                if (!one) {
                    System.out.print(" ");
                }
                System.out.print(num);
                one = false;
            }
        }

        System.out.println(" (" + max + " lan)");
    }
}