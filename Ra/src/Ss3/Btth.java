package Ss3;

import java.util.Scanner;

public class Btth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 100;
        int[] ids = new int[max];
        String[] titles = new String[max];
        int[] quantities = new int[max];
        int n = 0;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật số lượng");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp theo số lượng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.printf("%-10s | %-20s | %-10s\n", "Mã", "Tên", "Số lượng");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%-10d | %-20s | %-10d\n", ids[i], titles[i], quantities[i]);
                    }
                    break;

                case 2:
                    if (n >= max) {
                        System.out.println("Mảng đầy!");
                    } else {
                        System.out.print("Mã sách: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        int found = -1;
                        for(int i=0; i<n; i++) {
                            if(ids[i] == id) { found = i; break; }
                        }
                        if (found != -1) {
                            System.out.println("Lỗi: Mã sách đã tồn tại!");
                        } else {
                            ids[n] = id;
                            System.out.print("Tên sách: ");
                            titles[n] = sc.nextLine();
                            System.out.print("Số lượng: ");
                            quantities[n] = sc.nextInt();
                            n++;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã cần cập nhật: ");
                    int upId = sc.nextInt();
                    int upIdx = -1;
                    for (int i = 0; i < n; i++) {
                        if (ids[i] == upId) { upIdx = i; break; }
                    }
                    if (upIdx != -1) {
                        System.out.print("Số lượng mới: ");
                        quantities[upIdx] = sc.nextInt();
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã cần xóa: ");
                    int delId = sc.nextInt();
                    int delIdx = -1;
                    for (int i = 0; i < n; i++) {
                        if (ids[i] == delId) { delIdx = i; break; }
                    }
                    if (delIdx != -1) {
                        for (int i = delIdx; i < n - 1; i++) {
                            ids[i] = ids[i+1];
                            titles[i] = titles[i+1];
                            quantities[i] = quantities[i+1];
                        }
                        n--;
                        System.out.println("Đã xóa.");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.print("Từ khóa: ");
                    String key = sc.nextLine().toLowerCase();
                    for (int i = 0; i < n; i++) {
                        if (titles[i].toLowerCase().contains(key)) {
                            System.out.printf("%d - %s (%d)\n", ids[i], titles[i], quantities[i]);
                        }
                    }
                    break;

                case 6:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if (quantities[j] < quantities[j+1]) {
                                int tQ = quantities[j]; quantities[j] = quantities[j+1]; quantities[j+1] = tQ;
                                int tI = ids[j]; ids[j] = ids[j+1]; ids[j+1] = tI;
                                String tT = titles[j]; titles[j] = titles[j+1]; titles[j+1] = tT;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp.");
                    break;
            }
        }
    }
}