package Pratice1;
// PHÂN TÍCH THỪA SỐ NGUYÊN TỐ
// Hãy phân tích một số nguyên dương thành tích các thừa số nguyên tố.

// Input:
// - Dòng đầu tiên ghi số bộ test.
// - Mỗi bộ test viết trên một dòng số nguyên dương n không quá 9 chữ số.
// Output:
// - Mỗi bộ test viết ra thứ tự bộ test, sau đó lần lượt là các số nguyên tố
// khác nhau có trong tích, với mỗi số viết thêm số lượng số đó.
// - Xem ví dụ để hiểu rõ hơn về cách viết kết quả.

// Eg:
// Input:
// 3
// 60
// 128
// 10000
// Output:
// Test 1: 2 (2) 3 (1) 5 (1)
// Test 2: 2 (7)
// Test 3: 2 (4) 5 (4)

// Giới hạn thời gian: 2s
// Giới hạn bộ nhớ: 65536 Kb
import java.util.Scanner;
public class Phan_tich_thua_so_nto {
    public static void main(String[] args) {
        //Nhap du lieu
        Scanner sc = new Scanner(System.in);
        //Nhap so bo test
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            //Nhap n
            int n = sc.nextInt();
            for (int j = 2; i <= Math.sqrt(n); j++) {
                //Kiem tra n co phai la so nguyen to hay khong
                if (n % j == 0) {
                    //Khai bao bien dem
                    int cnt = 0;
                    //Dem so lan xuat hien cua j trong n
                    while (n % j == 0) {
                        //Tang bien dem
                        cnt++;
                        //Chia n cho j
                        n /= j;
                    }
                    //In ra ket qua va so lan xuat hien cua j trong n,
                    //sau do chia n cho j, tang bien dem, lap lai, 
                    //cho den khi n khong chia het cho j,
                    //chuyen sang so j tiep theo, lap lai,
                    //cho den khi n = 1, ket thuc, in ra ket qua,
                    //chuyen sang bo test tiep theo, lap lai,
                    //cho den khi het bo test, ket thuc, 
                    //in ra ket qua, ket thuc
                    System.out.print(j + " (" + cnt + ") ");
                }
            }
            //Kiem tra n co phai la so nguyen to hay khong
            //Neu n > 1, in ra n va so lan xuat hien cua n trong n
            //Neu n = 1, ket thuc, chuyen sang bo test tiep theo, lap lai,
            //cho den khi het bo test, ket thuc, in ra ket qua, ket thuc
            if (n > 1) {
                System.out.print(n+"(1)");
            }
            System.out.println();
        }
    }
}
