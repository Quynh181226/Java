package JavaCore.Ss7;

//[Bài tập 4] Quản lý lớp học với biến static dùng chung
//1. Mục tiêu
//Áp dụng static variable trong tình huống thực tế
//Phân biệt dữ liệu dùng chung và dữ liệu riêng
//2. Mô tả
//Lớp học có một quỹ chung cho tất cả sinh viên.
//Yêu cầu:
//Tạo lớp ClassRoom
//Biến static:
//classFund (quỹ lớp)
//Biến instance:
//tên sinh viên
//Phương thức:
//Đóng tiền vào quỹ
//Xem tổng quỹ lớp
//Tạo nhiều sinh viên và đóng tiền
//3. Kết quả mong muốn
//Quỹ lớp thay đổi dù thao tác từ nhiều đối tượng
//Hiểu rõ static đại diện cho “của chung”
public class B4Classroom {
    static double classFund = 0;
    String name;

    public B4Classroom(String name) {
        this.name = name;
    }

    public void addFund(double amount){
        classFund += amount;
        System.out.println("Dong tien thanh cong.");
    }
    public static void showFund(){
        System.out.println(classFund);
    }
}