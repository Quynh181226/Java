package JavaCore.Ss5;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mssvList = new String[100];
        int count = 0;

        int choice;
        do {
            displayMenu();
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayList(mssvList, count);
                    break;
                case 2:
                    count = addMssv(sc, mssvList, count);
                    break;
                case 3:
                    updateMssv(sc, mssvList, count);
                    break;
                case 4:
                    count = deleteMssv(sc, mssvList, count);
                    break;
                case 5:
                    searchMssv(sc, mssvList, count);
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh!!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== QUAN LY MA SO SINH VIEN =====");
        System.out.println("1. Hien thi danh sach MSSV");
        System.out.println("2. Them moi MSSV");
        System.out.println("3. Cap nhat MSSV");
        System.out.println("4. Xoa MSSV");
        System.out.println("5. Tim kiem MSSV");
        System.out.println("6. Thoat");
        System.out.println("===================================");
    }
    //1.Hiển thị: In ra danh sách MSSV hiện có
    private static void displayList(String[] mssvList, int cnt) {
        if (cnt == 0) {
            System.out.println("Danh sach MSSV rong!");
            return;
        }
        System.out.println("Danh sach MSSV hien co:");
        for (int i = 0; i < cnt; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }

    //2. Thêm mới (Có Regex): * Yêu cầu nhập MSSV mới
    //a. Kiểm tra định dạng: MSSV phải bắt đầu bằng chữ B, theo sau là đúng 7 chữ số (Ví dụ: B2101234)
    //b. Nếu sai yêu cầu nhập lại

    private static int addMssv(Scanner sc, String[] mssvList, int cnt) {
        if (cnt == 100) {
            System.out.println("Mang da day!!");
            return cnt;
        }

        String newMssv;
        do {
            System.out.print("Nhap MSSV moi (dinh dang: Bxxxxxxx): ");
            newMssv = sc.nextLine().trim().toUpperCase();
            if (!newMssv.matches("^B\\d{7}$")) {
                System.out.println("MSSV khong hop le! Phai bat dau bang 'B' va theo sau 7 chu so.");
            }
        } while (!newMssv.matches("^B\\d{7}$"));

        mssvList[cnt] = newMssv;
        cnt++;
        return cnt;
    }

    //3. Cập nhật: Nhập vị trí (index) cần sửa, kiểm tra tính hợp lệ của index và cho phép nhập MSSV mới (cũng phải thỏa mãn Regex)
    private static void updateMssv(Scanner sc, String[] mssvList, int cnt) {
        if (cnt == 0) {
            System.out.println("Danh sach rong! Khong the cap nhat.");
            return;
        }

        System.out.print("Nhap vi tri (index bat dau tu 0) can cap nhat: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 0 || index >= cnt) {
            System.out.println("Index khong hop le!!");
            return;
        }

        String updatedMssv;
        do {
            System.out.print("Nhap MSSV moi (dinh dang: Bxxxxxxx): ");
            updatedMssv = sc.nextLine().trim().toUpperCase();
            if (!updatedMssv.matches("^B\\d{7}$")) {
                System.out.println("MSSV khong hop le! Phai bat dau bang 'B' va theo sau 7 chu so.");
            }
        } while (!updatedMssv.matches("^B\\d{7}$"));

        mssvList[index] = updatedMssv;
    }

    //4. Xóa: Nhập một MSSV cụ thể. Nếu tìm thấy, thực hiện xóa và dồn mảng để đảm bảo tính liên tục
    private static int deleteMssv(Scanner sc, String[] mssvList, int cnt) {
        if (cnt == 0) {
            System.out.println("Danh sach rong! Khong the xoa.");
            return cnt;
        }

        System.out.print("Nhap MSSV can xoa: ");
        String targetMssv = sc.nextLine().trim().toUpperCase();

        int idx = -1;
        for (int i = 0; i < cnt; i++) {
            if (mssvList[i].equals(targetMssv)) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Khong tim thay MSSV: " + targetMssv);
            return cnt;
        }

        for (int i = idx; i < cnt - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        mssvList[cnt - 1] = null;
        cnt--;
        return cnt;
    }

    //5. Tìm kiếm (Regex): Nhập một chuỗi ký tự bất kỳ từ bàn phím
    //   Hiển thị tất cả các MSSV có chứa chuỗi ký tự đó (Không phân biệt hoa thường)
    private static void searchMssv(Scanner sc, String[] mssvList, int cnt) {
        if (cnt == 0) {
            System.out.println("Danh sach rong! Khong the tim kiem.");
            return;
        }

        System.out.print("Nhap chuoi ky tu can tim: ");
        String searchStr = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("Cac MSSV chua chuoi '" + searchStr + "':");
        for (int i = 0; i < cnt; i++) {
            if (mssvList[i].toLowerCase().contains(searchStr)) {
                System.out.println((i + 1) + ". " + mssvList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay MSSV nao chua chuoi do!");
        }
    }
}