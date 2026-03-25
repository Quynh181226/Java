package JavaAdvanced.Ss13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Phần 1 - Phân tích logic (Tại sao xảy ra lỗi?)
//Đoạn code hiện tại bị lỗi nghiêm trọng vì không sử dụng Transaction và đang chạy ở chế độ Auto-Commit mặc định của JDBC.
//Khi gọi conn = DatabaseManager.getConnection(); thì kết nối JDBC mặc định có autoCommit = true.
//Mỗi lần gọi ps1.executeUpdate() hoặc ps2.executeUpdate() đều là một transaction riêng biệt và được tự động commit ngay lập tức.
//Thứ tự thực thi trong code:
//ps1.executeUpdate() -> Trừ thuốc trong kho -> Commit ngay -> Thay đổi đã được lưu vĩnh viễn.
//ps2.executeUpdate() -> Ghi lịch sử cấp phát -> Nếu lỗi ở đây (mạng chập chờn, exception, timeout…) thì transaction thứ 2 bị rollback, nhưng transaction thứ 1 đã commit rồi.
//=> Kết quả: Thuốc đã bị trừ khỏi kho nhưng không có bản ghi lịch sử, đúng như khách hàng (Khoa Dược) báo cáo.
//Đây chính là vi phạm nguyên tắc Atomicity (Nguyên tử) của ACID. Hai thao tác phải là một giao dịch duy nhất: hoặc cả hai cùng thành công, hoặc cả hai cùng thất bại và rollback.
public class Ex1CapPhatThuoc {

    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();

            conn.setAutoCommit(false);

            String sqlUpdateInventory = "update Medicine_Inventory set quantity = quantity - 1 where medicine_id = ?";
            try (PreparedStatement ps1 = conn.prepareStatement(sqlUpdateInventory)) {
                ps1.setInt(1, medicineId);
                int rowsUpdated = ps1.executeUpdate();

                if (rowsUpdated == 0) {
                    throw new SQLException("Không tìm thấy thuốc!!");
                }
            }

            String sqlInsertHistory = "insert into Prescription_History (patient_id, medicine_id, date) values (?, ?, getdate())";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlInsertHistory)) {
                ps2.setInt(1, patientId);
                ps2.setInt(2, medicineId);
                ps2.executeUpdate();
            }

            conn.commit();
            System.out.println("Cấp phát thuốc thành công!");

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback transaction - Toàn bộ nghiệp vụ bị hủy bỏ.");
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
        Ex1CapPhatThuoc service = new Ex1CapPhatThuoc();
        service.capPhatThuoc(5, 123);
    }
}