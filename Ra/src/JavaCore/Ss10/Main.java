package JavaCore.Ss10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // B1
        B1.Shape circle = new B1.Circle(5);
        B1.Shape rectangle = new B1.Rectangle(5,5);
        System.out.printf("%.2f\n", circle.getArea());
        System.out.printf("%.2f\n", rectangle.getArea());
        System.out.printf("%.2f\n", circle.getPerimeter());
        System.out.printf("%.2f\n", rectangle.getPerimeter());

        // B2
        B2 b2 = new B2();
        B2.Vehicle car = b2.new Car("Car1");
        B2.Vehicle bicycle = b2.new Bicycle("Bicycle1");
        car.move();
        bicycle.move();

        // B3
        B3.Duck d = new B3.Duck("Duck");
        B3.Fish f = new B3.Fish("Fish");
        d.fly();
        d.swim();
        f.swim();

        // B4
        B4.RemoteControl smartLight = new B4.RemoteControl() {
            @Override
            public void powerOn() {
                System.out.println("den da bat");
            }
        };
        smartLight.powerOn();
        smartLight.checkBattery();

        // B5
        B5.Employee e1 = new B5.OfficeStaff("An", 8000);
        B5.Employee e2 = new B5.Manager("Binh", 10000);
        B5.Employee[] em = {e1, e2};
        for (B5.Employee e : em) {
            System.out.println(e.name + " " + e.calculateSalary());
        }

        // B6
        List<B6.Product> products = new ArrayList<>();
        products.add(new B6.Product("Banana", 20));
        products.add(new B6.Product("Apple", 15));
        products.add(new B6.Product("Orange", 25));

        // Anonymous Class: sắp xếp theo giá tăng dần
        Collections.sort(products, new Comparator<B6.Product>() {
            @Override
            public int compare(B6.Product p1, B6.Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        for (B6.Product p : products) {
            System.out.println(p.name + " " + p.price);
        }

        // Lambda Expression: sắp xếp theo tên A-Z
        products.sort((p1, p2) -> p1.name.compareTo(p2.name));

        for (B6.Product p : products) {
            System.out.println(p.name + " " + p.price);
        }

        // Anonymous Class: dùng khi cần nhiều phương thức hoặc có trạng thái (field) bên trong
        // Lambda: gọn hơn khi chỉ implement 1 phương thức duy nhất (functional interface)

        // Trường hợp BẮT BUỘC dùng Anonymous Class:
        // - Khi cần thêm thuộc tính nội bộ
        // - Khi cần logic phức tạp hoặc nhiều phương thức hỗ trợ
        // Lambda KHÔNG cho phép khai báo biến instance
    }
}