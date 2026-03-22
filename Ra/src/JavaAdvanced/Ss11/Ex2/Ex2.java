package JavaAdvanced.Ss11.Ex2;

import java.sql.*;

public class Ex2 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            con = getConnection();
            stmt = con.createStatement();

            String sql = "SELECT drug_name, quantity FROM drugs";
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("drug_name");
                int quantity = rs.getInt("quantity");
                System.out.println("Tên thuốc: " + name + " | Số lượng: " + quantity);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
