package JavaAdvanced.Ss11.Ex5.DAO;

import Session11.Ex05.DBContext.DBContext;
import Session11.Ex05.Model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // Lấy danh sách bác sĩ
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("specialty")
                ));
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy danh sách bác sĩ");
        }
        return list;
    }

    // Thêm bác sĩ
    public boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors(id, name, specialty) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialty());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Mã bác sĩ đã tồn tại!");
        } catch (Exception e) {
            System.out.println("❌ Lỗi thêm bác sĩ!");
        }
        return false;
    }

    // Thống kê chuyên khoa
    public void statisticBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) as total FROM doctors GROUP BY specialty";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getString("specialty") + ": " + rs.getInt("total"));
            }

        } catch (Exception e) {
            System.out.println("❌ Lỗi thống kê!");
        }
    }
}
