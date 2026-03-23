package JavaAdvanced.Ss11.Ex5;

import JavaAdvanced.Ss11.Ex5.DAO.DoctorDao;
import JavaAdvanced.Ss11.Ex5.entity.Doctor;

import java.sql.*;
import java.util.List;

public class HospitalConnection {
    final static String url="jdbc:mysql://localhost:3306/hospital";
    final static String user="root";
    final static String password="Phq#1812";
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("ket noi thanh cong");
            return connection;
        } catch (Exception e) {
            System.out.println("ket noi that bai");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctors = doctorDao.getdoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
        boolean insert=doctorDao.insertDoctor(new Doctor(100,"Nguyen Van A","Cardiology"));
        if(insert){
            System.out.println("Insert thanh cong");
        }else{
            System.out.println("Insert that bai");
        }
        DoctorDao thongke= new DoctorDao();
        thongke.thongke();

    }

    public static void closeAll(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
