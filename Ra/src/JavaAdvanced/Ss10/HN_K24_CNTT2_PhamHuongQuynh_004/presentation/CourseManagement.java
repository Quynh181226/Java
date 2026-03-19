package JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.presentation;

import JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.business.singleton.CourseBusiness;
import JavaAdvanced.Ss10.HN_K24_CNTT2_PhamHuongQuynh_004.entity.Course;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CourseManagement {
    private static final Scanner sc = new Scanner(System.in);
    private static final CourseBusiness db = CourseBusiness.getInstance();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=============QUẢN LÝ KHÓA HỌC=============");
            System.out.println("""
                1. Hiển thị danh sách toàn bộ khóa học
                2. Thêm mới khóa học
                3. Cập nhật thông tin khóa học theo mã
                4. Xóa khóa học theo mã
                5. Tìm kếm khóa học theo tên giảng viên
                6. Lọc khóa học đang mở
                7. Sắp xếp khóa học theo học phí giảm dần
                8. Thoát"""
            );
            System.out.println("========================================");

            int choice = getIntInput("Lựa chọn của bạn: ");
            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    searchCourse();
                    break;
                case 6:
                    db.filterActiveCourse();
                    break;
                case 7:
                    db.sortByFeeDesc();
                    break;
                case 8:
                    System.out.println("Exit program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void displayAll() {
        List<Course> list = db.getAllCourses();
        if (list.isEmpty()) {
            System.out.println("List empty");
            return;
        }

        for (Course c : list) {
            c.displayData();
        }

        System.out.println("Total: " + list.size());
    }

    private static void addCourse() {
        System.out.println("\n--- Thêm mới khóa học ---");

        while (true) {
            String id;
            do {
                id = generateCourseId();
            } while (db.findById(id).isPresent());
            System.out.println("Mã khóa học: " + id);

            String name;
            do {
                name = getStringInput("Nhập name: ");
                if (name.length() < 5) {
                    System.out.println("Name must be at least 5 characters");
                }
            } while (name.length() < 5);

            int credit;
            do {
                credit = getIntInput("Nhập credit: ");
                if (credit <= 0 || credit >= 10) {
                    System.out.println("Credit must be > 0 and < 10");
                }
            } while (credit <= 0 || credit >= 10);

            double fee;
            do {
                fee = getDoubleInput("Nhập tuition fee: ");
                if (fee <= 0) {
                    System.out.println("Tuition fee must be > 0");
                }
            } while (fee <= 0);

            String instructor = getStringInput("Nhập instructor: ");

            boolean status;
            while (true) {
                System.out.print("Nhập status (true/false): ");
                String input = sc.nextLine().trim().toLowerCase();
                if (input.equals("true")) {
                    status = true;
                    break;
                } else if (input.equals("false")) {
                    status = false;
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }

            Course c = new Course(id, name, credit, fee, instructor, status);
            db.addCourse(c);

            System.out.print("Bạn có muốn thêm tiếp không (Y/n)? ");
            String ans = sc.nextLine().trim();
            if (ans.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private static String generateCourseId() {
        int max = 0;
        for (Course c : db.getAllCourses()) {
            String id = c.getCourseId();
            if (id.startsWith("CO")) {
                try {
                    int num = Integer.parseInt(id.substring(2));
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return String.format("CO%03d", max + 1);
    }

    private static void updateCourse() {
        System.out.println("\n--- Cập nhật khóa học ---");
        String id = getStringInput("Nhập id: ");

        Optional<Course> existing = db.findById(id);
        if (existing.isEmpty()) {
            System.out.println("Course id not found");
            return;
        }

        Course course = existing.get();
        System.out.println("\nCurrent info:");
        course.displayData();

        System.out.println("""
            Chọn trường cập nhật:
            1. Tên
            2. Tín chỉ
            3. Học phí
            4. Giảng viên
            5. Trạng thái"""
        );

        int choice = getIntInput("Lựa chọn của bạn: ");

        String newName = course.getCourseName();
        int newCredit = course.getCredit();
        double newFee = course.getTuitionFee();
        String newInstructor = course.getInstructor();
        boolean newStatus = course.isStatus();

        switch (choice) {
            case 1:
                System.out.print("Nhập name mới: ");
                String name = sc.nextLine().trim();
                if (!name.isEmpty()) {
                    if (name.length() < 5) {
                        System.out.println("Name must be at least 5 characters");
                        return;
                    }
                    newName = name;
                }
                break;
            case 2:
                System.out.print("Nhập credit mới: ");
                String creditStr = sc.nextLine().trim();
                if (!creditStr.isEmpty()) {
                    try {
                        int credit = Integer.parseInt(creditStr);
                        if (credit <= 0 || credit >= 10) {
                            System.out.println("Credit must be > 0 and < 10");
                            return;
                        }
                        newCredit = credit;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        return;
                    }
                }
                break;
            case 3:
                System.out.print("Nhập tuition fee mới: ");
                String feeStr = sc.nextLine().trim();
                if (!feeStr.isEmpty()) {
                    try {
                        double fee = Double.parseDouble(feeStr);
                        if (fee <= 0) {
                            System.out.println("Tuition fee must be > 0");
                            return;
                        }
                        newFee = fee;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        return;
                    }
                }
                break;
            case 4:
                System.out.print("Nhập instructor mới: ");
                String instructor = sc.nextLine().trim();
                if (!instructor.isEmpty()) {
                    newInstructor = instructor;
                }
                break;
            case 5:
                System.out.print("Nhập status mới (true/false): ");
                String statusStr = sc.nextLine().trim().toLowerCase();
                if (!statusStr.isEmpty()) {
                    if (statusStr.equals("true")) {
                        newStatus = true;
                    } else if (statusStr.equals("false")) {
                        newStatus = false;
                    } else {
                        System.out.println("Invalid input");
                        return;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        Course updated = new Course(id, newName, newCredit, newFee, newInstructor, newStatus);
        db.updateCourse(id, updated);
    }

    private static void deleteCourse() {
        System.out.println("\n--- Xóa khóa học ---");
        String id = getStringInput("Nhập id: ");

        if (db.findById(id).isEmpty()) {
            System.out.println("Course id not found");
            return;
        }

        System.out.print("Confirm delete? (Y/n): ");
        String confirm = sc.nextLine().trim();
        if (confirm.isEmpty() || confirm.equalsIgnoreCase("y")) {
            if (db.deleteCourse(id)) {
                System.out.println("Course deleted");
            }
        } else {
            System.out.println("Delete cancelled");
        }
    }

    private static void searchCourse() {
        System.out.println("\n--- Tìm khóa học ---");
        if (db.getAllCourses().isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String keyword = getStringInput("Nhập instructor: ");
        db.searchByInstructor(keyword);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}