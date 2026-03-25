package JavaAdvanced.Ss13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Phần 1 - Phân tích logic (Tại sao xảy ra lỗi?)
// Đoạn code hiện tại đã dùng setAutoCommit(false) và commit(), nhưng vẫn sai nghiêm trọng.
// Khi lỗi xảy ra ở thao tác thứ 2 (UPDATE Invoices sai tên bảng), chương trình nhảy vào catch.
// Trong catch chỉ có System.out.println() để in lỗi, mà KHÔNG có conn.rollback().
// Khi exception xảy ra trước commit(), các thay đổi (trừ tiền ví) đang ở trạng thái "chưa commit".
// Vì không rollback() nên transaction bị treo lơ lửng, kết nối bị giữ lại, gây lãng phí tài nguyên
// và có thể làm hỏng các giao dịch khác.
// Hành động bị bỏ quên: Phải gọi conn.rollback() trong khối catch để hủy bỏ toàn bộ giao dịch.

public class Ex2ThanhToanVienPhi {
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();

            conn.setAutoCommit(false);

            String sqlDeductWallet = "update Patient_Wallet set balance = balance - ? where patient_id = ?";
            try (PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet)) {
                ps1.setDouble(1, amount);
                ps1.setInt(2, patientId);
                ps1.executeUpdate();
            }

            String sqlUpdateInvoice = "update Invoices set status = 'PAID' where invoice_id = ?";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice)) {
                ps2.setInt(1, invoiceId);
                ps2.executeUpdate();
            }

            conn.commit();
            System.out.println("Thanh toán hoàn tất!");

        } catch (Exception e) {
            System.out.println("Không thể hoàn tất thanh toán");
            System.out.println("Lỗi hệ thống: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback transaction - Toàn bộ nghiệp vụ thanh toán bị hủy bỏ. Tiền đã được hoàn lại vào ví.");
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
        Ex2ThanhToanVienPhi service = new Ex2ThanhToanVienPhi();
        service.thanhToanVienPhi(10, 1001, 1500000.0);
    }
}