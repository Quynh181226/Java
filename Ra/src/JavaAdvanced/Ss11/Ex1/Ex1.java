package JavaAdvanced.Ss11.Ex1;

import java.sql.*;

public class Ex1 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void getPatients() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM patients";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("patients_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng theo thứ tự ngược
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getPatients();
    }
}
