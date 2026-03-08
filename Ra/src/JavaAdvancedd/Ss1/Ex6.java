package JavaAdvancedd.Ss1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.Scanner;

public class Ex6 {
    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String msg){
            super(msg);
        }



    }
    public class Logger {
        public static void logError(String message, Exception e){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);

            System.out.println("[ERROR]" + time + " - " + message);
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
    }
    public static class User {

        private String name;
        private int age;

        public User(String name) {
            this.name = name;
        }

        public void setAge(int age) throws InvalidAgeException {

            if (age < 0) {
                throw new InvalidAgeException("Tuổi không thể âm!");
            }

            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public class UserService {

        public static void saveToFile(User user) throws IOException {

            System.out.println("Đang lưu dữ liệu người dùng vào file...");

            // giả lập lỗi ghi file
            throw new IOException("Không thể ghi dữ liệu vào file hệ thống.");
        }

        public static void processUserData(User user) throws IOException {

            System.out.println("Đang xử lý dữ liệu người dùng...");
            saveToFile(user);
        }
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Nhập tên người dùng: ");
            String name = scanner.nextLine();

            User user = new User(name);

            // Defensive programming
            if (user.getName() != null) {
                System.out.println("Xin chào " + user.getName());
            }

            // Bài 1: nhập năm sinh
            System.out.print("Nhập năm sinh: ");
            String yearStr = scanner.nextLine();

            int year = Integer.parseInt(yearStr);
            int age = 2026 - year;

            user.setAge(age);

            System.out.println("Tuổi người dùng: " + user.getAge());

            // Bài 2: chia nhóm
            System.out.print("Nhập tổng số người: ");
            int totalUsers = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số nhóm: ");
            int groups = Integer.parseInt(scanner.nextLine());

            if (groups == 0) {
                System.out.println("Không thể chia cho 0!");
            } else {
                int result = totalUsers / groups;
                System.out.println("Mỗi nhóm có: " + result + " người.");
            }

            // Bài 4: ghi file
            UserService.processUserData(user);

        }

        // lỗi parse số
        catch (NumberFormatException e) {
            Logger.logError("Người dùng nhập sai định dạng số", e);
        }

        // lỗi nghiệp vụ
        catch (InvalidAgeException e) {
            Logger.logError("Lỗi nghiệp vụ tuổi", e);
        }

        // lỗi môi trường
        catch (IOException e) {
            Logger.logError("Lỗi hệ thống khi ghi file", e);
        }

        finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }

        System.out.println("Chương trình kết thúc an toàn.");
    }
}
