package JavaCore.Ss8;

import java.util.Arrays;

public class StudentManager {
    private Student[] danhSach;
    private int soLuong;
    private static final int MAX = 100;

    public StudentManager() {
        danhSach = new Student[MAX];
        soLuong = 0;
    }

    // add student
    public boolean themSinhVien(Student sv) {
        if (soLuong >= MAX) {
            System.out.println("Danh sach day, khong the them!");
            return false;
        }
        if (timSinhVien(sv.getMaSV()) != null) {
            System.out.println("Ma SV da ton tai!");
            return false;
        }
        danhSach[soLuong] = sv;
        soLuong++;
        return true;
    }

    // display
    public void hienThiTatCa() {
        if (soLuong == 0) {
            System.out.println("Khong co sinh vien nao!");
            return;
        }
        System.out.printf("%-10s %-20s %-5s %-10s %-7s %-10s\n", "Ma SV", "Ho Ten", "Tuoi", "Gioi Tinh", "Diem TB", "Xep Loai");
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSach[i]);
        }
    }

    // search stu by ma or name
    public Student timSinhVien(String maSV) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSV().equals(maSV)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void timTheoTen(String ten) {
        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(danhSach[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay!");
        }
    }

    // upd stu
    public boolean capNhat(String maSV, String hoTen, int tuoi, String gioiTinh, double diemToan, double diemLy, double diemHoa) {
        Student sv = timSinhVien(maSV);
        if (sv == null) {
            System.out.println("Khong tim thay sinh vien!");
            return false;
        }
        if (!hoTen.isEmpty()) sv.setHoTen(hoTen);
        if (tuoi != -1) sv.setTuoi(tuoi);
        if (!gioiTinh.isEmpty()) sv.setGioiTinh(gioiTinh);
        if (diemToan != -1) sv.setDiemToan(diemToan);
        if (diemLy != -1) sv.setDiemLy(diemLy);
        if (diemHoa != -1) sv.setDiemHoa(diemHoa);
        return true;
    }

    // del stu
    public boolean xoaSinhVien(String maSV) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSV().equals(maSV)) {
                for (int j = i; j < soLuong - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }
                danhSach[soLuong - 1] = null;
                soLuong--;
                return true;
            }
        }
        System.out.println("Khong tim thay!");
        return false;
    }

    // Tính điểm TB và xếp loại (đã có trong Student)
    // sort score TB desc
    public void sapXepTheoDiemTB() {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = 0; j < soLuong - i - 1; j++) {
                if (danhSach[j].getDiemTB() < danhSach[j + 1].getDiemTB()) {
                    Student temp = danhSach[j];
                    danhSach[j] = danhSach[j + 1];
                    danhSach[j + 1] = temp;
                }
            }
        }
    }

    // a-z
    public void sapXepTheoTen() {
        for (int i = 0; i < soLuong - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < soLuong; j++) {
                if (danhSach[j].getHoTen().compareToIgnoreCase(danhSach[minIdx].getHoTen()) < 0) {
                    minIdx = j;
                }
            }
            Student temp = danhSach[minIdx];
            danhSach[minIdx] = danhSach[i];
            danhSach[i] = temp;
        }
    }

    // Thống kê
    public void thongKe() {
        if (soLuong == 0) {
            System.out.println("Khong co du lieu!");
            return;
        }
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        double tongTB = 0;
        Student maxSV = danhSach[0];
        Student minSV = danhSach[0];

        for (int i = 0; i < soLuong; i++) {
            Student sv = danhSach[i];
            tongTB += sv.getDiemTB();
            switch (sv.getXepLoai()) {
                case "Gioi": gioi++; break;
                case "Kha": kha++; break;
                case "Trung binh": tb++; break;
                case "Yeu": yeu++; break;
            }
            if (sv.getDiemTB() > maxSV.getDiemTB()) maxSV = sv;
            if (sv.getDiemTB() < minSV.getDiemTB()) minSV = sv;
        }

        System.out.println("Thong ke:");
        System.out.println("Gioi: " + gioi);
        System.out.println("Kha: " + kha);
        System.out.println("Trung binh: " + tb);
        System.out.println("Yeu: " + yeu);
        System.out.println("Sinh vien diem cao nhat: " + maxSV.getHoTen() + " (" + String.format("%.2f", maxSV.getDiemTB()) + ")");
        System.out.println("Sinh vien diem thap nhat: " + minSV.getHoTen() + " (" + String.format("%.2f", minSV.getDiemTB()) + ")");
        System.out.println("Diem TB chung: " + String.format("%.2f", tongTB / soLuong));
    }
}