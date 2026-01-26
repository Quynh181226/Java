package Ss2;

import java.util.Scanner;

//-- Vòng lặp
//1. Viết thuật toán kiểm tra số nguyên nhập vào và in ra thông báo
//kết luận số nhập vào có phải số nguyên tố hay không
//
//2. Tìm và in ra 100 số nguyên tố đầu tiên
//
//3. Viết chương trình thực hiện menu chức năng sau :
//        +------------------Menu---------------------+
//        |1. Nhập vào 1 số nguyên dương n            |
//        |2. Tính tổng của số chẵn và tổng số lẻ < n |
//        |3. Tìm các số hoàn hảo < n                 |
//        |4. Tính n!                                 |
//        |5. Thoát chương trình                      |
//        +-------------------------------------------+

public class Pratice {
    public static final String Reset = "\u001B[0m";
    public static final String YellowText = "\u001B[33m";
    public static final String CyanText = "\u001B[36m";
    public static final String GreenText = "\u001B[32m";
    public static final String RedText = "\u001B[31m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, n = 0;

        // Bai 1: Kiem tra so nguyen to (chay ngay dau chuong trinh)
        System.out.println(YellowText + "1. Kiem tra so nguyen to" + Reset);
        System.out.print("Nhap mot so nguyen: ");
        int soKiemTra = sc.nextInt();
        if (soKiemTra > 1) {
            if (isPrime(soKiemTra)) {
                System.out.println(GreenText + soKiemTra + " la so nguyen to" + Reset);
            } else {
                System.out.println(RedText + soKiemTra + " khong phai so nguyen to" + Reset);
            }
        } else {
            System.out.println(RedText + soKiemTra + " khong phai so nguyen to" + Reset);
        }
        System.out.println();

        // Bai 2: In 100 so nguyen to dau tien (chay ngay dau chuong trinh)
        System.out.println(YellowText + "2. In 100 so nguyen to dau tien" + Reset);
        printFirst100Primes();
        System.out.println("\n");

        // Menu - bai 3
        do {
            System.out.println(YellowText + "+------------------Menu---------------------+" + Reset);
            System.out.println(CyanText + "|1. Nhập vào 1 số nguyên dương n            |");
            System.out.println("|2. Tính tổng của số chẵn và tổng số lẻ < n |");
            System.out.println("|3. Tìm các số hoàn hảo < n                 |");
            System.out.println("|4. Tính n!                                 |");
            System.out.println("|5. Thoát chương trình                      |" + Reset);
            System.out.println(YellowText + "+-------------------------------------------+" + Reset);

            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap n: ");
                    n = sc.nextInt();

                    if (n > 0) {
                        // Nhập xong in ngay kết quả kiểm tra số nguyên tố (theo bài 1)
                        if (isPrime(n)) {
                            System.out.println(GreenText + "=>" + n + " la so nguyen to" + Reset);
                        } else {
                            System.out.println(RedText + "=>" + n + " khong phai so nguyen to" + Reset);
                        }
                    } else {
                        System.out.println(RedText + "Vui long nhap so nguyen duong!" + Reset);
                    }
                    break;

                case 2:
                    if (n <= 0) {
                        System.out.println(RedText + "Vui long nhap n truoc o muc 1!" + Reset);
                        break;
                    }
                    long tongChan = 0, tongLe = 0;
                    for (int i = 1; i < n; i++) {
                        if (i % 2 == 0) {
                            tongChan += i;
                        } else {
                            tongLe += i;
                        }
                    }
                    System.out.println(CyanText + "Tong so chan < " + n + " = " + tongChan);
                    System.out.println("Tong so le  < " + n + " = " + tongLe + Reset);
                    break;

                case 3:
                    if (n <= 0) {
                        System.out.println(RedText + "Vui long nhap n truoc o muc 1!" + Reset);
                        break;
                    }
                    System.out.println(CyanText + "Cac so hoan hao < " + n + ":" + Reset);
                    boolean co = false;
                    for (int i = 1; i < n; i++) {
                        if (perfectNum(i)) {
                            System.out.print(i + " ");
                            co = true;
                        }
                    }
                    if (!co) {
                        System.out.print("Khong co so hoan hao nao < " + n);
                    }
                    System.out.println(Reset);
                    break;

                case 4:
                    if (n <= 0) {
                        System.out.println(RedText + "Vui long nhap n truoc o muc 1!" + Reset);
                        break;
                    }
                    long giaiThua = 1;
                    for (int i = 1; i <= n; i++) {
                        giaiThua *= i;
                    }
                    System.out.println(CyanText + n + "! = " + giaiThua + Reset);
                    break;

                case 5:
                    System.out.println(GreenText + "Tam biet!" + Reset);
                    break;

                default:
                    System.out.println(RedText + "Lua chon khong hop le!" + Reset);
            }
            System.out.println();
        } while (choice != 5);

        sc.close();
    }

    // Check Prime
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Print 100 Prime first
    public static void printFirst100Primes() {
        int cnt = 0, num = 2;
        while (cnt < 100) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                cnt++;
                if (cnt % 10 == 0) System.out.println();
            }
            num++;
        }
    }

    public static boolean perfectNum(int n){
        if (n < 1) return false;
        int sum = 0;
        for(int i=1; i<=n/2; i++){
            if(n % i == 0) sum += i;
        }
        return sum == n;
    }
}