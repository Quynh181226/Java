package JavaAdvanced.Ss13.Ex4;

import java.util.ArrayList;
import java.util.List;

class BenhNhanDTO {
    private int maBenhNhan;
    private String hoTen;
    private String ngayNhapVien;
    private List<DichVu> dsDichVu = new ArrayList<>();

    public BenhNhanDTO(int maBenhNhan, String hoTen, String ngayNhapVien) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.ngayNhapVien = ngayNhapVien;
    }

    public void addDichVu(DichVu dichVu) {
        if (dichVu != null) {
            dsDichVu.add(dichVu);
        }
    }

    public int getMaBenhNhan() { return maBenhNhan; }
    public String getHoTen() { return hoTen; }
    public List<DichVu> getDsDichVu() { return dsDichVu; }
}