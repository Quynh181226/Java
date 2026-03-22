package JavaAdvanced.Ss11.Ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3 {
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

        String bedId = "Bed_999";

        try{
            con = getConnection();
            stmt = con.createStatement();

            String sql = "UPDATE beds SET bed_status = 'Đang sử dụng' WHERE bed_id = '" + bedId + "'";

            int rowsAffected = stmt.executeUpdate(sql);
            if(rowsAffected > 0) {
                System.out.println("Cập nhật thành công trạng thái giường");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
