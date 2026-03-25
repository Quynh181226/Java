package JavaAdvanced.Ss14.Exam3;

import java.sql.*;

public class Transfer {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Tranfer?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "Phq#1812";

        String senderId = "ACC01";
        String receiverId = "ACC02";
        double transferAmount = 1000.0;

        System.out.println("=== Bat dau chuyen khoan an toan ===");
        System.out.println("Tu: " + senderId + " -> Den: " + receiverId + " | So tien: " + transferAmount);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            if (!checkSenderBalance(conn, senderId, transferAmount)) {
                System.out.println("Chuyen khoan that bai");
                System.out.println("Tai khoan khong ton tai hoac so du khong du!!");
                return;
            }

            conn.setAutoCommit(false);

            try {
                callUpdateBalance(conn, senderId, -transferAmount);
                callUpdateBalance(conn, receiverId, transferAmount);

                conn.commit();
                System.out.println("Chuyen khoan thanh cong!!");

                displayFinalBalances(conn, senderId, receiverId);

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction da rollback do loi: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        }

        System.out.println("=== KET THUC CHUONG TRINH ===");
    }

    private static boolean checkSenderBalance(Connection conn, String accountId, double amount) throws SQLException {
        String sql = "select Balance from Accounts where AccountId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    double balance = rs.getDouble("Balance");
                    System.out.println("So du hien tai cua " + accountId + ": " + balance);
                    return balance >= amount;
                }
                return false;
            }
        }
    }

    private static void callUpdateBalance(Connection conn, String accountId, double amount) throws SQLException {
        String call = "{call sp_UpdateBalance(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(call)) {
            cs.setString(1, accountId);
            cs.setDouble(2, amount);
            cs.executeUpdate();
        }
    }

    private static void displayFinalBalances(Connection conn, String senderId, String receiverId) throws SQLException {
        String sql = "select AccountId, FullName, Balance from Accounts where AccountId = ? or AccountId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, senderId);
            ps.setString(2, receiverId);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\nBANG KET QUA:");
                System.out.println("---------------------------------------------");
                System.out.printf("%-10s %-20s %-15s%n", "AccountId", "FullName", "Balance");
                System.out.println("---------------------------------------------");
                while (rs.next()) {
                    System.out.printf("%-10s %-20s %-15.2f%n",
                            rs.getString("AccountId"),
                            rs.getString("FullName"),
                            rs.getDouble("Balance"));
                }
                System.out.println("---------------------------------------------");
            }
        }
    }
}