package JavaCore.Ss8;

import java.util.Scanner;

public class Main {
    private static StudentManager manager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            hienThiMenu();
            choice = nhapSo("Chon chuc nang (1-9): ");
            switch (choice) {
                case 1: themSinhVien(); break;
                case 2: manager.hienThiTatCa(); break;
                case 3: timKiem(); break;
                case 4: capNhat(); break;
                case 5: xoa(); break;
                case 6: tinhDiemVaXepLoai(); break;
                case 7: sapXep(); break;
                case 8: manager.thongKe(); break;
                case 9: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 9);
    }

    private static void hienThiMenu() {
        System.out.println("===== QUAN LY SINH VIEN =====");
        System.out.println("1. Them sinh vien moi");
        System.out.println("2. Hien thi tat ca sinh vien");
        System.out.println("3. Tim kiem sinh vien");
        System.out.println("4. Cap nhat thong tin sinh vien");
        System.out.println("5. Xoa sinh vien");
        System.out.println("6. Tinh diem trung binh va xep loai");
        System.out.println("7. Sap xep sinh vien");
        System.out.println("8. Thong ke");
        System.out.println("9. Thoat");
    }

    private static void themSinhVien() {
        String maSV = nhapChuoi("Nhap ma SV: ");
        String hoTen = nhapChuoi("Nhap ho ten: ");
        int tuoi = nhapSoTuoi("Nhap tuoi (18-30): ");
        String gioiTinh = nhapChuoi("Nhap gioi tinh (Nam/Nu): ");
        double diemToan = nhapDiem("Nhap diem Toan (0-10): ");
        double diemLy = nhapDiem("Nhap diem Ly (0-10): ");
        double diemHoa = nhapDiem("Nhap diem Hoa (0-10): ");

        Student1 sv = new Student1(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa);
        if (manager.themSinhVien(sv)) {
            System.out.println("Them thanh cong!");
        } else {
            System.out.println("Them that bai!");
        }
    }

    private static void timKiem() {
        int loai = nhapSo("Tim theo: 1. Ma SV, 2. Ten: ");
        if (loai == 1) {
            String maSV = nhapChuoi("Nhap ma SV: ");
            Student1 sv = manager.timSinhVien(maSV);
            if (sv != null) {
                System.out.println(sv);
            } else {
                System.out.println("Khong tim thay!");
            }
        } else if (loai == 2) {
            String ten = nhapChuoi("Nhap ten: ");
            manager.timTheoTen(ten);
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    private static void capNhat() {
        String maSV = nhapChuoi("Nhap ma SV: ");
        String hoTen = nhapChuoiOptional("Nhap ho ten moi (enter de bo qua): ");
        int tuoi = nhapSoOptional("Nhap tuoi moi (enter de bo qua): ");
        String gioiTinh = nhapChuoiOptional("Nhap gioi tinh moi (enter de bo qua): ");
        double diemToan = nhapDiemOptional("Nhap diem Toan moi (enter de bo qua): ");
        double diemLy = nhapDiemOptional("Nhap diem Ly moi (enter de bo qua): ");
        double diemHoa = nhapDiemOptional("Nhap diem Hoa moi (enter de bo qua): ");

        if (manager.capNhat(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa)) {
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Cap nhat that bai!");
        }
    }

    private static void xoa() {
        String maSV = nhapChuoi("Nhap ma SV: ");
        String xacNhan = nhapChuoi("Xac nhan xoa (y/n): ");
        if (xacNhan.equalsIgnoreCase("y")) {
            if (manager.xoaSinhVien(maSV)) {
                System.out.println("Xoa thanh cong!");
            } else {
                System.out.println("Xoa that bai!");
            }
        }
    }

    private static void tinhDiemVaXepLoai() {
        String maSV = nhapChuoi("Nhap ma SV: ");
        Student1 sv = manager.timSinhVien(maSV);
        if (sv != null) {
            System.out.println("Diem TB: " + String.format("%.2f", sv.getDiemTB()));
            System.out.println("Xep loai: " + sv.getXepLoai());
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    private static void sapXep() {
        int loai = nhapSo("Sap xep theo: 1. Diem TB giam dan, 2. Ten A-Z: ");
        if (loai == 1) {
            manager.sapXepTheoDiemTB();
        } else if (loai == 2) {
            manager.sapXepTheoTen();
        } else {
            System.out.println("Lua chon khong hop le!");
            return;
        }
        System.out.println("Da sap xep!");
        manager.hienThiTatCa();
    }

    // Các hàm hỗ trợ nhập liệu
    private static String nhapChuoi(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }

    private static String nhapChuoiOptional(String msg) {
        System.out.print(msg);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? "" : input;
    }

    private static int nhapSo(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }

    private static int nhapSoOptional(String msg) {
        System.out.print(msg);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return -1;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so! Bo qua.");
            return -1;
        }
    }

    private static int nhapSoTuoi(String msg) {
        while (true) {
            int num = nhapSo(msg);
            if (num >= 18 && num <= 30) return num;
            System.out.println("Tuoi phai tu 18-30!");
        }
    }

    private static double nhapDiem(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double diem = Double.parseDouble(scanner.nextLine().trim());
                if (diem >= 0 && diem <= 10) return diem;
                System.out.println("Diem phai tu 0-10!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }

    private static double nhapDiemOptional(String msg) {
        System.out.print(msg);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return -1;
        try {
            double diem = Double.parseDouble(input);
            if (diem >= 0 && diem <= 10) return diem;
            System.out.println("Diem phai tu 0-10! Bo qua.");
            return -1;
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so! Bo qua.");
            return -1;
        }
    }
}