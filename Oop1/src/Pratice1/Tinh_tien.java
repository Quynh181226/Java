package Pratice1;

import java.util.*;

//Cửa hàng điện máy – điện lạnh cần lập hóa đơn tính tiền cho khách hàng. Mỗi mặt hàng sẽ có đơn giá và một số tiền được gọi là chiết khấu trên tổng hóa đơn. Số tiền phải thanh toán sẽ bằng đơn giá * số lượng sau đó trừ đi tiền chiết khấu.
//Hãy tính tiền cho từng hóa đơn và sắp xếp theo số tiền giảm dần.
//
//Input
//Dòng đầu ghi số lượng hóa đơn. Không quá 20.
//Mỗi thông tin hóa đơn gồm 5 dòng:
//Mã mặt hàng (xâu ký tự độ dài không quá 10, không có khoảng trống)
//Tên mặt hàng (xâu ký tự độ dài không quá 100, có thể có khoảng trống)
//Số lượng mua (không quá 50)
//Đơn giá (số nguyên dương có thể đến 10 chữ số)
//Tiền chiết khấu của hóa đơn (có thể đến 9 chữ số).
//
//Output
//Ghi ra danh sách hóa đơn đã sắp xếp, trong đó mỗi dòng gồm đầy đủ 6 thông tin: mã mặt hàng, tên mặt hàng, số lượng mua, đơn giá, chiết khấu và tổng tiền. Mỗi thông tin cách nhau một khoảng trống.
//
//Ví dụ
//Input
//3
//ML01
//May lanh SANYO
//12
//4000000
//2400000
//ML02
//May lanh HITACHI
//4
//2550000000
//0
//ML03
//May lanh NATIONAL
//5
//3000000
//150000
//Output
//ML02 May lanh HITACHI 4 2550000000 0 10200000000
//ML01 May lanh SANYO 12 4000000 2400000 45600000
//ML03 May lanh NATIONAL 5 3000000 150000 14850000
class Bill implements Comparable<Bill>{
    private String id;
    private String name;
    private long quantity;
    private long price;
    private long discount;

    public Bill(String id, String name, long quantity, long price, long discount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public long getTotalPrice() {
        return quantity * price - discount;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + quantity + " " + price + " " + discount + " " + getTotalPrice();
    }

    @Override
    public int compareTo(Bill x) {
        return Long.compare(x.getTotalPrice(), this.getTotalPrice());
    }
}

public class Tinh_tien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Bill[] bills = new Bill[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            long quantity = sc.nextLong();
            long price = sc.nextLong();
            long discount = sc.nextLong();
            sc.nextLine();
            bills[i] = new Bill(id, name, quantity, price, discount);
        }
        Arrays.sort(bills);
        for (Bill x : bills) {
            System.out.println(x);
        }
    }
}