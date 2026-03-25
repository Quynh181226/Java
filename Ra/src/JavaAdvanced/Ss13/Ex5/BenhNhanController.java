package JavaAdvanced.Ss13.Ex5;

import JavaAdvanced.Ss13.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class BenhNhanController {

    public List<String> xemGiuongTrong() {
        List<String> list = new ArrayList<>();
        String sql = "select maGiuong from GiuongBenh where trangThai = 'Trống' order by maGiuong";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add("Giường số: " + rs.getInt("maGiuong") + " - Trống");
            }
        } catch (SQLException e) {
            list.add("Lỗi khi lấy danh sách giường: " + e.getMessage());
        }
        return list;
    }

    public void tiepNhanBenhNhan(String tenBenhNhan, int tuoi, int maGiuong, double soTienTamUng) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            String sqlInsertBN = "insert into BenhNhan (tenBenhNhan, tuoi, maGiuong, ngayTiepNhan) " +
                    "values (?, ?, ?, getdate())";
            PreparedStatement ps1 = conn.prepareStatement(sqlInsertBN, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, tenBenhNhan);
            ps1.setInt(2, tuoi);
            ps1.setInt(3, maGiuong);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            int maBenhNhan = 0;
            if (rs.next()) {
                maBenhNhan = rs.getInt(1);
            }

            String sqlUpdateGiuong = "update GiuongBenh set trangThai = 'Đã có người' " +
                    "where maGiuong = ? and trangThai = 'Trống'";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateGiuong);
            ps2.setInt(1, maGiuong);
            int rowsGiuong = ps2.executeUpdate();
            if (rowsGiuong == 0) {
                throw new SQLException("Giường số " + maGiuong + " không tồn tại hoặc đã có người nằm!");
            }

            String sqlInsertTamUng = "insert into TamUng (maBenhNhan, soTienTamUng, ngayThu) " +
                    "values (?, ?, getdate())";
            PreparedStatement ps3 = conn.prepareStatement(sqlInsertTamUng);
            ps3.setInt(1, maBenhNhan);
            ps3.setDouble(2, soTienTamUng);
            ps3.executeUpdate();

            conn.commit();
            System.out.println("Tiếp nhận thành công! Bệnh nhân '" + tenBenhNhan + "' (Mã: " + maBenhNhan + ") đã được xếp giường " + maGiuong);

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback toàn bộ transaction - Không có thay đổi nào được lưu.");
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi rollback: " + ex.getMessage());
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
}