package JavaCore.Ss6;

import java.util.Date;

////Tất các các lớp trong Java đều kết thừa từ lớp object
public class Demo {
    //Thuộc tính
    String studentId;
    String fullName;
    Date dateOfBirth;
    String email;
    String phoneNumber;

    //Phương thức
    //Phương thức khởi tạo: constructor là 1 phương thức đặc biệt dùng để khởi tạo object
    //Dùng để thiết lập các giá trị ban đầu cho các thuộc tính
    public Demo(){
        studentId = "1234";
        fullName = "John Doe";
        dateOfBirth = new Date();
        phoneNumber = "123456789";
        email = "default@email.com";
    }

    //this dùng để và khi nào dùng tại sao
    //this = tham chiếu tới object hiện tại (instance đang được tạo)
    //dùng khi tên tham số trùng với tên thuộc tính
    //nếu không dùng this thì studentId = studentId là vô nghĩa
    public Demo(String studentId, String fullName, Date dateOfBirth, String email, String phoneNumber) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Constructor Overloading
    //1 class có thể có nhiều constructor với tham số khác nhau
    public Demo(String studentId){
        this.studentId = studentId;
        this.fullName = "Unknown";
        this.dateOfBirth = new Date();
        this.email = "unknown@email.com";
        this.phoneNumber = "N/A";
    }

    //Hàm tạo là... -> hàm dùng để tạo object và gán dữ liệu ban đầu

    void checkIn(){
        System.out.println("Student "+fullName+" checked in at "+new Date());
    }

    void doHomework(){
        System.out.println("Student "+fullName+" did homework at "+new Date());
    }

    //Override method toString()
    //Ghi đè phương thức mặc định để in object dễ đọc hơn
    @Override
    public String toString() {
        return "Demo{" +
                "studentId='" + studentId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //Khởi tạo đối tượng
        //Cấp phát bộ nhớ cho đối tượng Student trong Heap
        Demo student = new Demo();

        //Gán các thông tin của đối tượng
        student.studentId="S001";
        student.fullName="Sam";
        student.email="s@gmail.com";
        student.dateOfBirth=new Date();

        //Gọi phương thức
        student.checkIn();
        student.doHomework();

        //Object and Instance
        //Object = đối tượng thực tế trong bộ nhớ
        //Instance = 1 bản thể cụ thể của class
        Demo student1 = new Demo();
        Demo student2 = new Demo("12");

        //Heap lưu giá trị của object
        //Stack lưu địa chỉ tham chiếu
        //-> biến student chỉ trỏ tới vùng nhớ của đối tượng object được lưu thực tế trong heap

        //Demo tham chiếu object
        Demo student3 = student; // student3 trỏ cùng object với student
        student3.fullName = "Changed Name";

        //student và student3 cùng trỏ 1 object
        System.out.println(student.fullName);
        System.out.println(student3.fullName);

        //Static demo
        //static là thuộc tính/phương thức dùng chung cho tất cả object
        //nếu thay đổi static ở 1 object thì object khác cũng bị ảnh hưởng

        //Final demo
        //final = hằng số, không thể gán lại giá trị
        final String role = "STUDENT";

        //In object
        System.out.println(student);
        System.out.println(student2);
    }
}
