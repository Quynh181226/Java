package JavaCore.Ss10;
//[Bài tập] Thiết kế khung quản lý Phương tiện (Abstract Class)
//
//1. Mục tiêu
//Sử dụng Abstract Class để tạo bản thiết kế khung cho các loại phương tiện.
//Hiểu cách sử dụng Constructor trong lớp trừu tượng để khởi tạo thuộc tính cho lớp con.
//2. Mô tả Một bãi xe cần quản lý thông tin các loại phương tiện. Các phương tiện đều có tên hãng nhưng cách thức di chuyển khác nhau.
//Yêu cầu:
//Tạo lớp trừu tượng Vehicle với thuộc tính protected String brand và một constructor để khởi tạo hãng xe.
//Định nghĩa phương thức trừu tượng void move().
//Triển khai lớp Car (in ra "Di chuyển bằng động cơ") và Bicycle (in ra "Di chuyển bằng sức người") kế thừa từ Vehicle.
//Xuất ra thông tin: [Tên hãng] - Cách di chuyển: [Mô tả].
//3. Kết quả mong muốn
//Hiển thị đúng tên hãng xe và cách thức di chuyển tương ứng của từng loại xe.
public class B2 {
    abstract class Vehicle{
        protected String brand;

        public Vehicle(String brand){
            this.brand=brand;
        }

        abstract void move();
    }

    class Car extends Vehicle{
        public Car(String brand){
            super(brand);
        }

        @Override
        void move() {
            System.out.println(this.brand + " - Cách di chuyển: Di chuyển bằng động cơ");
        }
    }

    class Bicycle extends Vehicle{
        public Bicycle(String brand){
            super(brand);
        }

        @Override
        void move() {
            System.out.println(brand + " - Cách di chuyển: Di chuyển bằng sức người");
        }
    }
}
