package JavaAdvanced.Ss2;

//[Bài tập] Giải quyết xung đột "Diamond Problem"
//1. Mục tiêu
//Học viên hiểu Diamond Problem và giải quyết xung đột
//2. Mô tả
//Giải quyết xung đột "Diamond Problem": Hệ thống có hai Interface: UserActions và AdminActions.
//Cả hai đều có phương thức mặc định là void logActivity(String activity).
//Nếu lớp SuperAdmin thực thi cả hai interface này, vấn đề gì sẽ xảy ra?
//Lập trình viên phải làm gì để mã nguồn có thể biên dịch được?
//3. Kết quả mong muốn
//Sinh viên tự định nghĩa các class/interface UserActions, AdminActions, SuperAdmin
//Giải quyết Diamond để có thể biên dịch được chương trình.
//Trong chương trình chính, thực hiện logActivity cho đối tượng superadmin thuộc lớp SuperAdmin.
public class Ex5 {
    interface AdminActions {
        default void logActivity(String activity) {
            System.out.println("Admin action: " + activity);
        }
    }

    public static class SuperAdmin implements UserActions, AdminActions{

        @Override
        public void logActivity(String activity) {
            AdminActions.super.logActivity(activity);
        }
    }

    public interface UserActions {
        default void logActivity(String activity){
            System.out.println("User action: " + activity);
        }
    }

    public static void main(String[] args) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.logActivity("Xóa người dùng");
    }
}
