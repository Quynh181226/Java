package JavaAdvanced.Ss11.Ex4;

import java.sql.*;
import java.util.Scanner;

public class Ex4 {
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên bệnh nhân: ");
        String input = scanner.nextLine();

        // Loại bỏ ký tự nguy hiểm
        input = input.replace("--", "")
                .replace(";", "")
                .replace("'", "");

        try {
            con = getConnection();
            stmt = con.createStatement();

            String sql = "SELECT * FROM patients WHERE patients_name LIKE " + "'%" + input + "%'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("patients_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
