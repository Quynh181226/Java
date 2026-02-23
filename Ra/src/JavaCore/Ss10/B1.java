package JavaCore.Ss10;
//[Bài tập] Quản lý hình học cơ bản với Interface
//
//1. Mục tiêu
//Sử dụng Interface để định nghĩa hành vi chung cho các đối tượng hình học.
//Triển khai phương thức (Override) để tính toán diện tích và chu vi cho từng hình cụ thể.
//2. Mô tả Xây dựng một hệ thống tính toán cho các loại hình học khác nhau. Dù mỗi hình có công thức riêng, nhưng tất cả đều phải có khả năng tính diện tích và chu vi.
//Yêu cầu:
//Tạo interface Shape chứa hai phương thức trừu tượng: double getArea() và double getPerimeter().
//Triển khai lớp Circle (thuộc tính radius) và Rectangle (thuộc tính width, height) thực thi interface Shape.
//Trong hàm main, tạo các đối tượng và xuất ra kết quả diện tích, chu vi của từng hình.
//3. Kết quả mong muốn
//Hệ thống in ra diện tích và chu vi chính xác của Hình tròn và Hình chữ nhật dựa trên dữ liệu nhập vào.
public class B1 {
    interface Shape{
        double getArea();
        double getPerimeter();
    }

    public static class Circle implements Shape{
        double radius;

        public Circle(double r){
            this.radius=r;
        }

        @Override
        public double getArea() {
            return Math.PI*radius*radius;
        }

        @Override
        public double getPerimeter() {
            return 2*Math.PI*radius;
        }
    }

    public static class Rectangle implements Shape{
        double height;
        double width;

        public Rectangle(double h,double w){
            this.height=h;
            this.width=w;
        }

        @Override
        public double getArea() {
            return height*width;
        }

        @Override
        public double getPerimeter() {
            return 2*(height+width);
        }
    }
}

