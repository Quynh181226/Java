package JavaAdvanced.Ss13;

import java.sql.*;

/*
 * BÀI TẬP THỰC HÀNH TỔNG HỢP - HỆ THỐNG QUẢN LÝ XUẤT VIỆN VÀ THANH TOÁN
 *
 * Mục tiêu: Vận dụng Transaction trong JDBC để đảm bảo All-or-Nothing cho 3 thao tác xuất viện.
 *
 * 3 bảng được sử dụng:
 * 1. PATIENTS (maBenhNhan, tenBenhNhan, trangThai)
 * 2. BEDS (maGiuong, maBenhNhan, trangThai)
 * 3. INVOICES (maHoaDon, maBenhNhan, soTien, ngayLap)
 *
 * Chức năng xuất viện bao gồm 3 thao tác trong 1 Transaction:
 *   1. Lập hóa đơn (INSERT INTO INVOICES)
 *   2. Cập nhật trạng thái bệnh nhân thành 'Đã xuất viện'
 *   3. Giải phóng giường bệnh (UPDATE BEDS)
 */
public class BtthXuatVienThanhToan {
    public void xuatVien(int maBenhNhan, double soTienHoaDon) {
        Connection conn = null;

        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            System.out.println("Đang xử lý xuất viện cho bệnh nhân mã: " + maBenhNhan);

            String sqlInsertInvoice = "insert into INVOICES (maBenhNhan, soTien, ngayLap) values (?, ?, getdate())";
            try (PreparedStatement ps1 = conn.prepareStatement(sqlInsertInvoice)) {
                ps1.setInt(1, maBenhNhan);
                ps1.setDouble(2, soTienHoaDon);
                ps1.executeUpdate();
                System.out.println("Đã lập hóa đơn với số tiền: " + soTienHoaDon + " VND");
            }

            String sqlUpdatePatient = "update PATIENTS set trangThai = 'Đã xuất viện' where maBenhNhan = ?";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdatePatient)) {
                ps2.setInt(1, maBenhNhan);
                int rowsPatient = ps2.executeUpdate();
                if (rowsPatient == 0) {
                    throw new SQLException("Không tìm thấy bệnh nhân mã " + maBenhNhan);
                }
                System.out.println("Đã cập nhật trạng thái bệnh nhân thành 'Đã xuất viện'");
            }

            String sqlReleaseBed = "update BEDS set maBenhNhan = null, trangThai = 'Trống' where maBenhNhan = ?";
            try (PreparedStatement ps3 = conn.prepareStatement(sqlReleaseBed)) {
                ps3.setInt(1, maBenhNhan);
                int rowsBed = ps3.executeUpdate();
                if (rowsBed == 0) {
                    throw new SQLException("Không tìm thấy giường đang sử dụng cho bệnh nhân " + maBenhNhan);
                }
                System.out.println("Đã giải phóng giường bệnh thành công");
            }

            conn.commit();
            System.out.println("XUẤT VIỆN THÀNH CÔNG! Toàn bộ 3 thao tác đã được thực hiện.");

        } catch (Exception e) {
            System.out.println("LỖI: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("ĐÃ ROLLBACK TOÀN BỘ TRANSACTION - Không có thay đổi nào được lưu.");
                } catch (SQLException rollbackEx) {
                    System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        BtthXuatVienThanhToan service = new BtthXuatVienThanhToan();

        System.out.println("=== TEST CASE 1: HAPPY PATH (Thành công) ===");
        service.xuatVien(101, 4500000.0);

        /*
        service.xuatVien(101, 5000000.0);
        */
    }
}