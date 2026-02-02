package JavaCore.Ss7;

import java.util.ArrayList;

//[Bài tập 6] Thiết kế hệ thống hoàn chỉnh với static và final
//1. Mục tiêu
//Tổng hợp: static variable, static method, final
//Tư duy thiết kế class đúng chuẩn
//2. Mô tả
//Thiết kế hệ thống quản lý tài khoản đơn giản.
//Yêu cầu:
//Lớp User:
//id (final, không thay đổi)
//username, password
//Lớp UserManager:
//static danh sách người dùng
//static method thêm, tìm kiếm người dùng
//Không cho phép thay đổi id sau khi tạo
//3. Kết quả mong muốn
//Áp dụng đúng static cho dữ liệu dùng chung
//Áp dụng final để bảo vệ dữ liệu quan trọng
//Code thể hiện tư duy OOP tốt
public class B6User {
    public final int ID;
    String username;
    String password;

    public B6User(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public class UserManager {
        public static ArrayList<B6User> list = new ArrayList<>();

        public static void addUser(B6User u) {
            list.add(u);
            System.out.println("Them thanh cong");
        }

        public static void searchUser(int id) {
            B6User foundUser = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).ID == id) {
                    foundUser = list.get(i);
                }
            }
            if (foundUser != null) {
                System.out.println("===============");
                System.out.println("ID: " + foundUser.ID);
                System.out.println("NAME: " + foundUser.username);
            } else {
                System.out.println("KO tim thay user voi id " + id);
            }
        }
    }
}
