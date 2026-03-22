package JavaAdvanced.Ss11.Ex5;

import Session11.Ex05.DAO.DoctorDAO;
import Session11.Ex05.Model.Doctor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorDAO dao = new DoctorDAO();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    List<Doctor> list = dao.getAllDoctors();
                    for (Doctor d : list) {
                        System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
                    }
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập chuyên khoa: ");
                    String spec = sc.nextLine();

                    if (id.isEmpty() || name.isEmpty() || spec.isEmpty()) {
                        System.out.println("❌ Không được để trống!");
                        break;
                    }

                    dao.addDoctor(new Doctor(id, name, spec));
                    break;

                case 3:
                    dao.statisticBySpecialty();
                    break;

                case 4:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("❌ Chọn sai!");
            }
        }
    }
}