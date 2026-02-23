package JavaCore.Ss10;
//[Bài tập] Hệ thống đa khả năng của Sinh vật (Đa kế thừa Interface)
//
//1. Mục tiêu
//Sử dụng sức mạnh của Đa kế thừa thông qua Interface để mô tả các khả năng khác nhau của đối tượng.
//Phân biệt mối quan hệ IS-A (bản chất) và CAN-DO (khả năng).
//2. Mô tả Mô phỏng các loài sinh vật trong tự nhiên. Có loài chỉ biết bơi, có loài vừa biết bơi vừa biết bay.
//Yêu cầu:
//Tạo abstract class Animal với thuộc tính name.
//Tạo hai interface: Swimmable (phương thức swim()) và Flyable (phương thức fly()).
//Triển khai lớp Duck (Vịt) kế thừa Animal và thực thi cả hai interface.
//Triển khai lớp Fish (Cá) kế thừa Animal và chỉ thực thi Swimmable.
//3. Kết quả mong muốn
//Đối tượng Duck gọi được cả hai hành động bơi và bay, trong khi Fish chỉ gọi được hành động bơi.
public class B3 {
    abstract static class Animal{
        protected String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    interface Swimmable {
        void swim();
    }
    interface Flyable {
        void fly();
    }

    static class Duck extends Animal implements Swimmable, Flyable{
        public Duck(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println(this.name + " swim");
        }

        @Override
        public void fly() {
            System.out.println(this.name + " fly");
        }
    }

    static class Fish extends Animal implements Swimmable{
        public Fish(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println(this.name + " swim");
        }
    }
}
