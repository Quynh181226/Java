package JavaAdvanced.Ss12.Ex5;

import JavaAdvanced.Ss12.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HospitalDAO {
    private static final String DB_NAME = "MedicalAppointmentDB";

    private Connection getConnection() throws Exception {
        Class.forName(DbConfig.DRIVER);
        return DriverManager.getConnection(DbConfig.getURL(DB_NAME), DbConfig.USER, DbConfig.PASS);
    }

    public List<PatientModel> getAll() throws Exception {
        List<PatientModel> list = new ArrayList<>();
        String sql = "SELECT patient_id, full_name, age, department FROM Inpatients";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new PatientModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        }
        return list;
    }

    public void addPatient(String name, int age, String dep) throws Exception {
        String sql = "INSERT INTO Inpatients (full_name, age, department) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, dep);
            pstmt.executeUpdate();
        }
    }

    public void updateCondition(int id, String condition) throws Exception {
        String sql = "UPDATE Inpatients SET medical_condition = ? WHERE patient_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, condition);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public double calculateFee(int id) throws Exception {
        String sql = "{call CALCULATE_DISCHARGE_FEE(?, ?)}";
        try (Connection conn = getConnection(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            return cstmt.getDouble(2);
        }
    }
}
