package JavaCore.Ss13;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ex1.execute();
        Ex2.execute();
        Ex3.execute();
        Ex4.patientCheckIn("A");
        Ex4.patientCheckIn("B");
        Ex4.emergencyCheckIn("C");

        Ex4.treatPatient();
        Ex4.treatPatient();
        Ex4.treatPatient();
        Ex4.treatPatient();

//      Ex5
        Scanner sc = new Scanner(System.in);
        List<Patient> list = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\n--- QUẢN LÝ BỆNH VIỆN ---");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện (Xóa)");
            System.out.println("4. Sắp xếp (Tuổi giảm, Tên tăng)");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Thoát");
            System.out.print("Chọn lệnh: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    String newId;

                    while (true) {
                        System.out.print("Nhập ID bệnh nhân: ");
                        newId = sc.nextLine().trim();
                        if (newId.isEmpty()) {
                            System.out.println("Lỗi: ID không được để trống!");
                            continue;
                        }
                        String finalNewId = newId;
                        boolean isDuplicate = list.stream().anyMatch(p -> p.id.equalsIgnoreCase(finalNewId));
                        if (isDuplicate) {
                            System.out.println("Lỗi: ID '" + newId + "' đã tồn tại. Vui lòng nhập ID khác!");
                        } else {
                            break;
                        }
                    }

                    System.out.print("Nhập họ tên bệnh nhân: ");
                    String name = sc.nextLine().trim();
                    int age = -1;
                    while (age < 0 || age > 150) {
                        try {
                            System.out.print("Nhập tuổi: ");
                            age = Integer.parseInt(sc.nextLine());
                            if (age < 0 || age > 150) System.out.println("Lỗi: Tuổi phải từ 0 - 150!");
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Vui lòng nhập số nguyên cho tuổi!");
                        }
                    }

                    System.out.print("Nhập chẩn đoán bệnh: ");
                    String diag = sc.nextLine().trim();
                    Patient newPatient = new Patient(newId, name, age, diag);
                    list.add(newPatient);
                    System.out.println("=> Tiếp nhận thành công bệnh nhân: " + name);
                    break;
                }
                case 2: {
                    String id;
                    System.out.println("Nhập ID để cập nhật: ");
                    id = sc.nextLine().trim();
                    Patient p = list.stream().filter(patient -> patient.id.equalsIgnoreCase(id)).findFirst().orElse(null);
                    if (p != null) {
                        String newDiag;
                        System.out.println("Moi nhap chan doan moi: ");
                        newDiag = sc.nextLine().trim();
                        p.diagnosis = newDiag;
                        System.out.println("Cap nhat thanh cong");
                    } else {
                        System.out.println("Khong tim thay benh nhan voi ID " + id);
                    }
                    break;
                }
                case 3: {
                    String id;
                    System.out.println("Nhập ID để cho xuat vien: ");
                    id = sc.nextLine().trim();
                    Patient p = list.stream().filter(patient -> patient.id.equalsIgnoreCase(id)).findFirst().orElse(null);
                    if (p != null) {
                        list.remove(p);
                        System.out.println("Da cho benh nhan xuat vien thanh cong");
                    } else {
                        System.out.println("Khong tim thay benh nhan voi ID " + id);
                    }
                    break;
                }
                case 4: {
                    if (list.isEmpty()) {
                        System.out.println("Không có gì để sắp xếp!");
                    } else {
                        list.sort(Comparator.comparingInt((Patient p) -> p.age).reversed().thenComparing(patient -> patient.fullName));
                        System.out.println("=> Đã sắp xếp: Ưu tiên người già, sau đó đến Tên A-Z.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n" + "=".repeat(70));
                    System.out.println(String.format("%-10s | %-20s | %-5s | %-20s", "ID", "HỌ TÊN", "TUỔI", "CHẨN ĐOÁN"));
                    System.out.println("-".repeat(70));

                    if (list.isEmpty()) {
                        System.out.println("            DANH SÁCH ĐANG TRỐNG");
                    } else {
                        // Sử dụng forEach để in từng bệnh nhân theo định dạng bảng
                        list.forEach(p -> {
                            System.out.printf("%-10s | %-20s | %-5d | %-20s\n",
                                    p.id, p.fullName, p.age, p.diagnosis);
                        });
                    }
                    System.out.println("=".repeat(70));
                    System.out.println("Tổng số: " + list.size() + " bệnh nhân.");
                    break;
                }
                case 6:
                    running = false;
                    System.out.println("Da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon ko hop le");
            }
        }

        Ex6.execute();
    }
}
