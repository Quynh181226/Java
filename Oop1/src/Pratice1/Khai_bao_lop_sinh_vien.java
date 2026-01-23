package Pratice1;
//Bai 5: Khai bao lop sinh vien
//Viết chương trình khai báo lớp sinh viên với các thuộc tính được nhập trên 6 dòng lần lượt là:
//Mã sinh viên: dạng xâu ký tự, độ dài không quá 10, không trùng nhau
//Họ tên: dạng xâu ký tự, độ dài không quá 50
//Giới tính: xâu ký tự với một trong hai giá trị: “Nam” hoặc “Nu”
//Lớp: xâu ký tự, độ dài không quá 30
//Email: độ dài không quá 50
//Số điện thoại: độ dài không quá 10
//Tạo các đối tượng sinh viên và in thông tin của từng đối tượng ra màn hình.
//Input
//Dòng đầu ghi số sinh viên
//6 dòng tiếp theo lần lượt mỗi dòng nhập 1 thông tin như mô tả của 1 đối tượng sinh viên
//Output
//In ra thông tin của từng sinh viên, mỗi sinh viên nằm trên một dòng, mỗi thông tin cách nhau bởi dấu phẩy (có khoảng trắng sau dấu phẩy).
//Ví dụ
//Input:
//2
//B21DCCN111
//Hoang Van An
//Nam
//D21CQCN01-B
//hva@gmail.com
//0912999888
//B21DCAT999
//Tran Van Binh
//Nam
//D21CQAT01-B
//tvb@gmail.com
//838831503
//Output:
//B21DCCN111, Hoang Van An, Nam, D21CQCN01-B, hva@gmail.com, 0912999888
//B21DCAT999, Tran Van Binh, Nam, D21CQAT01-B, tvb@gmail.com, 838831503
//Chú ý: Yêu cầu bắt buộc phải khai báo lớp và viết theo hướng đối tượng. Nếu không thì không có điểm.
//Giới hạn thời gian: 1s
//Giới hạn bộ nhớ: 200000Kb
import java.util.Scanner;

class Student {
    private String msv;
    private String name;
    private String gender;
    private String className;
    private String email;
    private String phone;
    public Student(String msv, String name, String gender, String className, String email, String phone) {
        this.msv=msv;
        this.name=name;
        this.gender=gender;
        this.className=className;
        this.email=email;
        this.phone=phone;
    }
    @Override
    public String toString() {
        return msv+", "+name+", "+gender+", "+className+", "+email+", "+phone;
    }
}
public class Khai_bao_lop_sinh_vien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        Student[] stu=new  Student[n];
//        List<Student> stu=new ArrayList<Student>();
        for(int i=0;i<n;i++){
            String msv=sc.nextLine();
            String name=sc.nextLine();
            String gender=sc.nextLine();
            String className=sc.nextLine();
            String email=sc.nextLine();
            String phone=sc.nextLine();
//            stu.add(new Student(msv, name, gender, className, email, phone));
            stu[i]=new Student(msv, name, gender, className, email, phone);
        }
        sc.close();
        for(Student s: stu){
            System.out.println(s);
        }
    }
}
