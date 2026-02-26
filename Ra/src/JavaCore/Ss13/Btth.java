package JavaCore.Ss13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Lớp Patient
//Bài tập thực hành
//I. Mục tiêu bài thực hành:
//Hiểu và thực hành các chức năng CRUD (Create, Read, Update, Delete) trong một hệ thống quản lý thông tin bệnh nhân.
//Áp dụng kỹ thuật tìm kiếm và sắp xếp trong việc quản lý danh sách bệnh nhân.
//Làm quen với việc thiết kế hệ thống menu để tương tác với người dùng và thực hiện các thao tác quản lý dữ liệu với kiểu dữ liệu List.
//Phát triển khả năng làm việc với các lớp và đối tượng trong hệ thống quản lý dữ liệu bệnh nhân.
//II. Cài đặt các lớp sau:
//Lớp Patient:
//Thuộc tính:
//ID bệnh nhân (sử dụng int hoặc String).
//Tên bệnh nhân (kiểu String).
//Tuổi (kiểu int).
//Giới tính (kiểu String).
//Bệnh lý (kiểu String).
//Các phương thức:
//Constructor để khởi tạo thông tin bệnh nhân.
//Các getter và setter cho các thuộc tính.
//Lớp PatientManager:
//Thuộc tính:
//Danh sách bệnh nhân (dùng ArrayList<Patient> hoặc LinkedList<Patient>).
//Các phương thức:
//addPatient(Patient patient): Thêm bệnh nhân.
//removePatient(int patientId): Xóa bệnh nhân theo ID.
//updatePatient(int patientId, Patient updatedPatient): Cập nhật thông tin bệnh nhân theo ID.
//searchPatientByName(String name): Tìm kiếm bệnh nhân theo tên.
//displayPatients(): Hiển thị danh sách bệnh nhân.
//Lớp MainMenu:
//Các phương thức:
//displayMenu(): Hiển thị các lựa chọn menu.
//handleMenuSelection(): Xử lý lựa chọn của người dùng.
//III. Các chức năng cần triển khai
//Thêm bệnh nhân (Create):
//Nhập thông tin bệnh nhân (ID, tên, tuổi, giới tính, bệnh lý).
//Lưu thông tin vào danh sách bệnh nhân.
//Xóa bệnh nhân (Delete):
//Nhập ID bệnh nhân cần xóa.
//Tìm và xóa bệnh nhân khỏi danh sách.
//Cập nhật thông tin bệnh nhân (Update):
//Nhập ID bệnh nhân cần cập nhật.
//Nhập thông tin mới cho bệnh nhân (tên, tuổi, bệnh lý).
//Cập nhật lại thông tin trong danh sách bệnh nhân.
//Tìm kiếm bệnh nhân (Search):
//Tìm kiếm bệnh nhân theo tên.
//Nếu có bệnh nhân trùng khớp, hiển thị thông tin chi tiết.
//Hiển thị danh sách bệnh nhân (Display):
//Hiển thị thông tin tất cả các bệnh nhân trong hệ thống.
//Kết thúc chương trình
//Người dùng nhập lựa chọn để chương trình kết thúc

class Patient1 {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient1(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Tên: %-20s | Tuổi: %-4d | Giới tính: %-8s | Bệnh lý: %s",
                id, name, age, gender, disease);
    }
}

class PatientManager {
    private List<Patient1> patients = new ArrayList<>();

    public void addPatient(Patient1 patient) {
        for (Patient1 p : patients) {
            if (p.getId() == patient.getId()) {
                System.out.println("ID " + patient.getId() + " đã tồn tại!");
                return;
            }
        }
        patients.add(patient);
        System.out.println("Thêm bệnh nhân thành công!");
    }

    public void removePatient(int patientId) {
        boolean removed = patients.removeIf(p -> p.getId() == patientId);
        if (removed) {
            System.out.println("Xóa bệnh nhân ID " + patientId + " thành công!");
        } else {
            System.out.println("Không tìm thấy bệnh nhân ID " + patientId);
        }
    }

    public void updatePatient(int patientId, String newName, int newAge, String newGender, String newDisease) {
        for (Patient1 p : patients) {
            if (p.getId() == patientId) {
                p.setName(newName);
                p.setAge(newAge);
                p.setGender(newGender);
                p.setDisease(newDisease);
                System.out.println("Cập nhật thông tin bệnh nhân ID " + patientId + " thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân ID " + patientId);
    }

    public void searchPatientByName(String name) {
        boolean found = false;
        System.out.println("\nKết quả tìm kiếm: " + name);
        for (Patient1 p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy bệnh nhân nào!");
        }
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách bệnh nhân trống!");
            return;
        }
        System.out.println("\nDanh sách bệnh nhân:");
        for (Patient1 p : patients) {
            System.out.println(p);
        }
    }

    public boolean isEmpty() {
        return patients.isEmpty();
    }
}

public class Btth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();
        int choice;

        do {
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient(sc, manager);
                    break;

                case 2:
                    if (manager.isEmpty()) {
                        System.out.println("Danh sách trống!");
                        break;
                    }
                    System.out.print("Nhập ID cần xóa: ");
                    int idRemove = sc.nextInt();
                    sc.nextLine();
                    manager.removePatient(idRemove);
                    break;

                case 3:
                    if (manager.isEmpty()) {
                        System.out.println("Danh sách trống!");
                        break;
                    }
                    updatePatient(sc, manager);
                    break;

                case 4:
                    System.out.print("Nhập tên (hoặc một phần tên) cần tìm: ");
                    String nameSearch = sc.nextLine().trim();
                    manager.searchPatientByName(nameSearch);
                    break;

                case 5:
                    manager.displayPatients();
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }

    private static void displayMenu() {
        System.out.println("===== QUẢN LÝ BỆNH NHÂN =====");
        System.out.println("1. Thêm bệnh nhân");
        System.out.println("2. Xóa bệnh nhân theo ID");
        System.out.println("3. Cập nhật thông tin bệnh nhân");
        System.out.println("4. Tìm kiếm bệnh nhân theo tên");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("0. Thoát");
        System.out.println("============================");
    }

    private static void addPatient(Scanner sc, PatientManager manager) {
        System.out.println("\n--- Thêm bệnh nhân ---");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Họ tên: ");
        String name = sc.nextLine().trim();

        System.out.print("Tuổi: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Giới tính: ");
        String gender = sc.nextLine().trim();

        System.out.print("Bệnh lý: ");
        String disease = sc.nextLine().trim();

        Patient1 p = new Patient1(id, name, age, gender, disease);
        manager.addPatient(p);
    }

    private static void updatePatient(Scanner sc, PatientManager manager) {
        System.out.println("\n--- Cập nhật bệnh nhân ---");
        System.out.print("Nhập ID cần cập nhật: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Tên mới: ");
        String name = sc.nextLine().trim();

        System.out.print("Tuổi mới: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Giới tính mới: ");
        String gender = sc.nextLine().trim();

        System.out.print("Bệnh lý mới: ");
        String disease = sc.nextLine().trim();

        manager.updatePatient(id, name, age, gender, disease);
    }
}
