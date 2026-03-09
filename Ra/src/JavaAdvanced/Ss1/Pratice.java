package JavaAdvanced.Ss1;

import java.util.Scanner;

public class Pratice {
    static Scanner sc = new Scanner(System.in);

    /*
        Tạo ra các phương thức nhập và trả về các giá trị gồm
        1. Số nguyên (int, byte, short, long)
        2. Số thực (double, float)
        3. Kí tự và chuỗi
        4. Boolean
        Lưu ý: Xử lý hết lỗi (ngoại lệ ) sinh ra khi nhập, nếu không đúng thì nhập lại
    */
    public static void main(String[] args) {
        int n = inputInt("Nhập int: ");
        double m = inputDouble("Nhập double: ");
        char ch = inputChar("Nhập char: ");
        String str = inputString("Nhập String: ");
        boolean b = inputBoolean("Nhập boolean: ");

        System.out.println("\n--- Dữ liệu đã nhập ---");
        System.out.printf("Int: %d, Double: %f, Char: %c, String: %s, Boolean: %b\n", n, m, ch, str, b);
    }

    public static int inputInt(String mes) {
        while (true) {
            try {
                System.out.print(mes);
                // return Integer.parseInt(mes); -> Sai: mes là cái nhãn truyền vào
                // throw new RuntimeException(e); -> Sai: làm dừng chương trình
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
            }
        }
    }

    public static double inputDouble(String mes) {
        while (true) {
            try {
                System.out.print(mes);
                // return Double.parseDouble(mes); -> Sai: phải đọc từ scanner
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số thực!");
            }
        }
    }

    public static String inputString(String mes) {
        while (true) {
            System.out.print(mes);
            String inp = sc.nextLine().trim();
            if (!inp.isEmpty()) {
                return inp;
            }
            System.out.println("Lỗi: Chuỗi không được để trống!");
        }
    }

    public static char inputChar(String mes) {
        while (true) {
            System.out.print(mes);
            // return mes.charAt(0); -> Sai: lấy chữ cái đầu của cái nhãn "char: "
            String input = sc.nextLine();
            if (input.length() == 1) {
                return input.charAt(0);
            }
            System.out.println("Lỗi: Vui lòng chỉ nhập 1 kí tự!");
        }
    }

    public static boolean inputBoolean(String mes) {
        while (true) {
            System.out.print(mes + " (true/false): ");
            // return Boolean.parseBoolean(mes); -> Sai: parse nhầm nhãn
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Lỗi: Chỉ nhận giá trị 'true' hoặc 'false'!");
        }
    }

    // Bổ sung thêm các kiểu số nguyên khác theo yêu cầu đề bài
    public static byte inputByte(String mes) {
        while (true) {
            try {
                System.out.print(mes);
                return Byte.parseByte(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập kiểu byte (-128 đến 127)!");
            }
        }
    }

    public static float inputFloat(String mes) {
        while (true) {
            try {
                System.out.print(mes);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số thực (float)!");
            }
        }
    }
}