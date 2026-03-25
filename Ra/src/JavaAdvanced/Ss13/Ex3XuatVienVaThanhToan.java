package JavaAdvanced.Ss13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//1. Phân tích bài toán (I/O)
//Input:
//int maBenhNhan: Mã bệnh nhân (khóa chính)
//double tienVienPhi: Số tiền viện phí cần thanh toán
//Output:
//Nếu thành công: In ra thông báo “Xuất viện và thanh toán thành công!” + Commit toàn bộ 3 thao tác.
//Nếu thất bại (thiếu tiền, bệnh nhân không tồn tại, lỗi SQL…): Rollback toàn bộ, in ra thông báo lỗi rõ ràng.
//2. Đề xuất giải pháp
//Sử dụng JDBC Transaction thủ công:
//conn.setAutoCommit(false) để gom 3 câu lệnh UPDATE vào 1 giao dịch.
//Thực hiện theo thứ tự: kiểm tra số dư → trừ tiền → giải phóng giường → cập nhật trạng thái bệnh nhân.
//Sử dụng try-catch-finally kết hợp commit() / rollback() để đảm bảo All or Nothing.
//Xử lý Bẫy 1 bằng cách SELECT số dư trước khi trừ.
//Xử lý Bẫy 2 bằng cách kiểm tra rowsAffected == 0 sau mỗi executeUpdate().
//3. Thiết kế các bước xử lý
//Lấy Connection từ DatabaseManager.
//Tắt AutoCommit (setAutoCommit(false)).
//Bẫy 1: SELECT số dư tạm ứng → kiểm tra nếu < tienVienPhi thì throw Exception.
//UPDATE trừ tiền viện phí → kiểm tra rowsAffected.
//UPDATE giải phóng giường bệnh (bed status = 'Trống') → kiểm tra rowsAffected.
//UPDATE trạng thái bệnh nhân = 'Đã xuất viện' → kiểm tra rowsAffected.
//Nếu tất cả thành công → conn.commit().
//Catch bất kỳ Exception nào → conn.rollback().
//Finally: khôi phục AutoCommit = true và đóng Connection.
public class Ex3XuatVienVaThanhToan {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            String sqlSelectBalance = "select balance from Patient_Advance where patient_id = ?";
            double currentBalance = 0.0;
            try (PreparedStatement psSelect = conn.prepareStatement(sqlSelectBalance)) {
                psSelect.setInt(1, maBenhNhan);
                try (ResultSet rs = psSelect.executeQuery()) {
                    if (rs.next()) {
                        currentBalance = rs.getDouble("balance");
                    } else {
                        throw new SQLException("Bệnh nhân không tồn tại hoặc chưa có số dư tạm ứng!");
                    }
                }
            }

            if (currentBalance < tienVienPhi) {
                throw new SQLException("Số dư tạm ứng không đủ để thanh toán viện phí. Số dư hiện tại: "
                        + currentBalance + ", cần thanh toán: " + tienVienPhi);
            }

            String sqlDeduct = "update Patient_Advance set balance = balance - ? where patient_id = ?";
            try (PreparedStatement ps1 = conn.prepareStatement(sqlDeduct)) {
                ps1.setDouble(1, tienVienPhi);
                ps1.setInt(2, maBenhNhan);
                int rows1 = ps1.executeUpdate();
                if (rows1 == 0) {
                    throw new SQLException("Không thể trừ tiền - Bệnh nhân không tồn tại!");
                }
            }

            String sqlReleaseBed = "update Bed set status = 'Trống' where patient_id = ?";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlReleaseBed)) {
                ps2.setInt(1, maBenhNhan);

                int rows2 = ps2.executeUpdate();
                if (rows2 == 0) {
                    throw new SQLException("Không tìm thấy giường bệnh của bệnh nhân này để giải phóng!");
                }
            }

            String sqlUpdatePatient = "update Patient set status = 'Đã xuất viện' where patient_id = ?";
            try (PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePatient)) {
                ps3.setInt(1, maBenhNhan);
                int rows3 = ps3.executeUpdate();
                if (rows3 == 0) {
                    throw new SQLException("Không tìm thấy bệnh nhân để cập nhật trạng thái xuất viện!!");
                }
            }

            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công cho bệnh nhân mã: " + maBenhNhan);

        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình xuất viện: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback toàn bộ transaction - Không có thay đổi nào được lưu.");
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
        Ex3XuatVienVaThanhToan service = new Ex3XuatVienVaThanhToan();
        service.xuatVienVaThanhToan(101, 2500000.0);
    }
}