package JavaCore.Ss8.HN_KS24_CNTT1_PhamHuongQuynh;

import java.util.Scanner;

public class Exam2 {

    public static class Student {
        private String id;
        private String name;
        private double score;

        public Student() {
            this.id = "";
            this.name = "";
            this.score = 0.0;
        }

        public Student(String id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public double getScore() { return score; }

        public void setId(String id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setScore(double score) { this.score = score; }

        public String getRank() {
            if (score >= 8.0) return "Gioi";
            else if (score >= 6.5) return "Kha";
            else return "Trung Binh";
        }

        @Override
        public String toString() {
            return String.format("%-10s %-25s %-8.2f %-12s", id, name, score, getRank());
        }
    }

    private static Student[] students;
    private static int n;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== QUAN LY DIEM SINH VIEN =====");
        n = getIntInput("Nhap so luong sinh vien toi da: ");
        while (n <= 0) {
            System.out.println("So luong phai lon hon 0!");
            n = getIntInput("Nhap so luong sinh vien toi da: ");
        }

        students = new Student[n];

        int choice;
        do {
            showMenu();
            choice = getIntInput("Chon chuc nang: ");
            switch (choice) {
                case 1:
                    inputStuList();
                    break;
                case 2:
                    showList();
                    break;
                case 3:
                    searchByAcademic();
                    break;
                case 4:
                    sortByAcademicDesc();
                    break;
                case 5:
                    System.out.println("Exit!!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!!!");
            }
            System.out.println();
        } while (choice != 5);

        sc.close();
    }

    private static void showMenu() {
        System.out.println("1. Nhap danh sach sinh vien");
        System.out.println("2. Hien thi danh sach sinh vien");
        System.out.println("3. Tim kiem sinh vien theo Hoc luc");
        System.out.println("4. Sap xep theo hoc luc giam dan");
        System.out.println("5. Thoat");
        System.out.println("==================================");
    }

    private static void inputStuList() {
        if (n == 0) {
            System.out.println("Chua khoi tao danh sach!");
            return;
        }

        int remaining = n - getCurrCnt();
        if (remaining <= 0) {
            System.out.println("Danh sach da day! Khong the them nua.");
            return;
        }

        int numToAdd = getIntInput("Nhap danh sach sinh vien?: ");
        if (numToAdd > remaining) {
            numToAdd = remaining;
            System.out.println("Chi con trong " + remaining + " cho, se them " + numToAdd + " sinh vien.");
        }
        if (numToAdd <= 0) return;

        int curr = getCurrCnt();

        for (int i = 0; i < numToAdd; i++) {
            System.out.println("\nSinh vien" + (curr + i + 1) + ":");
            String id;
            do {
                id = getStringInput("Ma SV: ").trim();
                if (!isValidId(id)) {
                    System.out.println("Ma SV khong hop le!! Phai bat dau bang 'SV' va co 3 chu so.");
                }
            } while (!isValidId(id));

            String name = getStringInput("Ho va ten: ").trim();

            double score = getDoubleInput("Diem trung binh (0-10): ");
            while (score < 0 || score > 10) {
                System.out.println("Diem phai tu 0 den 10!");
                score = getDoubleInput("Diem trung binh (0-10): ");
            }

            students[curr + i] = new Student(id, name, score);
        }
    }

    private static int getCurrCnt() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] != null) count++;
        }
        return count;
    }

    private static boolean isValidId(String id) {
        if (id == null || !id.startsWith("SV") || id.length() != 5) return false;
        for (int i = 2; i < 5; i++) {
            if (!Character.isDigit(id.charAt(i))) return false;
        }
        return true;
    }

    private static void showList() {
        int count = getCurrCnt();
        if (count == 0) {
            System.out.println("Chua co sinh vien nao!");
            return;
        }

        System.out.println("\n===== DANH SACH SINH VIEN =====");
        System.out.printf("%-5s %-10s %-25s %-8s %-12s\n", "STT", "Ma SV", "Ho va ten", "Diem", "Hoc luc");

        int stt = 1;
        for (int i = 0; i < n; i++) {
            if (students[i] != null) {
                System.out.printf("%-5d %s\n", stt++, students[i]);
            }
        }
    }

    private static void searchByAcademic() {
        int count = getCurrCnt();
        if (count == 0) {
            System.out.println("Chua co sinh vien nao!");
            return;
        }

        String rank = getStringInput("Nhap hoc luc can tim (Gioi / Kha / Trung Binh): ").trim();
        boolean found = false;

        System.out.println("\nKet qua tim kiem hoc luc: " + rank);
        System.out.printf("%-10s %-25s %-8s %-12s\n", "Ma SV", "Ho va ten", "Diem", "Hoc luc");

        for (int i = 0; i < n; i++) {
            if (students[i] != null && students[i].getRank().equalsIgnoreCase(rank)) {
                System.out.println(students[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien nao co hoc luc: " + rank);
        }
    }

    private static void sortByAcademicDesc() {
        int count = getCurrCnt();
        if (count <= 1) {
            System.out.println("Khong du du lieu de sap xep!!");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j] != null && students[j + 1] != null &&
                        students[j].getScore() < students[j + 1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        showList();
    }

    private static int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
            }
        }
    }

    private static double getDoubleInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc hop le!!");
            }
        }
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
}