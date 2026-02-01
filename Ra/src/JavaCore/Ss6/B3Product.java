package JavaCore.Ss6;

//[Bài tập 3] Quản lý sản phẩm với đóng gói dữ liệu
//1. Mục tiêu
//Hiểu và áp dụng Encapsulation
//Sử dụng private + getter/setter
//2. Mô tả
//Hệ thống bán hàng cần kiểm soát chặt dữ liệu sản phẩm.
//
//Yêu cầu:
//Tạo lớp Product với:
//Thuộc tính private: mã SP, tên SP, giá bán
//Tạo getter/setter:
//Setter giá phải kiểm tra giá > 0
//Phương thức hiển thị thông tin sản phẩm
//Thử set giá không hợp lệ và quan sát kết quả
//3. Kết quả mong muốn
//Không truy cập trực tiếp thuộc tính từ bên ngoài
//Setter kiểm soát được dữ liệu
//Hiểu rõ ý nghĩa của đóng gói
public class B3Product {
    private int id;
    private String name;
    private double price;

    public B3Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        if(price < 0){
            System.out.println("Price invalid");
        }else{
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo(){
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }
}
