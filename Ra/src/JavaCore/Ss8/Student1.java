package JavaCore.Ss8;

public class Student1 {
    private String maSV;
    private String hoTen;
    private int tuoi;
    private String gioiTinh;
    private double diemToan;
    private double diemLy;
    private double diemHoa;
    private double diemTB;
    private String xepLoai;

    public Student1(String maSV, String hoTen, int tuoi, String gioiTinh, double diemToan, double diemLy, double diemHoa) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.diemTB = tinhDiemTB();
        this.xepLoai = xepLoai();
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
        this.diemTB = tinhDiemTB();
        this.xepLoai = xepLoai();
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
        this.diemTB = tinhDiemTB();
        this.xepLoai = xepLoai();
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
        this.diemTB = tinhDiemTB();
        this.xepLoai = xepLoai();
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    private double tinhDiemTB() {
        return (diemToan + diemLy + diemHoa) / 3;
    }

    private String xepLoai() {
        double minDiem = Math.min(diemToan, Math.min(diemLy, diemHoa));
        if (diemTB >= 8.0 && minDiem >= 6.5) {
            return "Gioi";
        } else if (diemTB >= 6.5 && minDiem >= 5.0) {
            return "Kha";
        } else if (diemTB >= 5.0 && minDiem >= 3.5) {
            return "Trung binh";
        } else {
            return "Yeu";
        }
    }

    public String toString() {
        return String.format("%-10s %-20s %-5d %-10s %-7.2f %-10s", maSV, hoTen, tuoi, gioiTinh, diemTB, xepLoai);
    }
}