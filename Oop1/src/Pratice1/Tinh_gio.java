package Pratice1;
import java.util.Arrays;
import java.util.Scanner;
//Quán Game mùa này vắng khách nên chủ quán quyết định tính tiền chi tiết đến từng phút. Dựa trên dữ liệu giờ vào và giờ ra, hãy tính thời gian chơi game của các Game thủ nhé.
//
//Input
//
//Dòng đầu của dữ liệu vào ghi số lượng game thủ trong ngày (không quá 20).
//
//Thông tin về một game thủ đến chơi game được ghi lại trên 4 dòng lần lượt là:
//
//Mã người chơi (xâu ký tự độ dài không quá 10, không có khoảng trống)
//Tên người chơi (xâu ký tự độ dài không quá 100, có thể có khoảng trống).
//Giờ vào (định dạng hh:mm)
//Giờ ra (định dạng hh:mm)
//
//Dữ liệu vào đảm bảo không có cặp game thủ nào có thời gian bằng nhau.
//
//Ouput
//
//Ghi ra danh sách game thủ đã được sắp xếp theo thời gian chơi game giảm dần.
//
//Ví dụ
//Input
//3
//01T
//Nguyen Van An
//09:00
//10:30
//06T
//Hoang Van Nam
//15:30
//18:00
//02I
//Tran Hoa Binh
//09:05
//10:00
//Output
//06 Hoang Van Nam 2 gio 30 phut
//01 Nguyen Van An 1 gio 30 phut
//02 Tran Hoa Binh 0 gio 55 phut
class Player implements Comparable<Player> {

    public String id, name, timeIn, timeOut;
    public int time;

    public Player(String id, String name, String timeIn, String timeOut) {
        this.id = id;
        this.name = name;
        this.time = 60 * (Integer.parseInt(timeOut.substring(0, 2))
                - Integer.parseInt(timeIn.substring(0, 2)))
                + (Integer.parseInt(timeOut.substring(3))
                - Integer.parseInt(timeIn.substring(3)));
    }

    public String getTime() {
        int h = time / 60;
        int m = time % 60;
        return String.format("%d gio %d phut", h, m);
    }

    @Override
    public String toString() {

        return id + " " + name + " " + getTime();
    }

    @Override
    //sắp xếp giảm dần
    public int compareTo(Player o) {
        return -(this.time - o.time);
    }
}
public class Tinh_gio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Player[] list = new Player[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            String timeIn = sc.nextLine();
            String timeOut = sc.nextLine();
            list[i] = new Player(id, name, timeIn, timeOut);
        }

        Arrays.sort(list);
        for (Player e : list) {
            System.out.println(e);
        }
    }
}


