package Pratice1;

import java.util.Scanner;

public class So_uu_the {
    //Cho một số nguyên dương lớn có nhiều hơn 20 chữ số nhưng không quá 1000 chữ số. Một số nguyên dương được coi là “số ưu thế chẵn” nếu số chữ số của nó là chẵn và số chữ số chẵn nhiều hơn số chữ số lẻ.
    //Một số nguyên dương được coi là “số ưu thế lẻ” nếu số chữ số của nó là lẻ và số chữ số lẻ nhiều hơn số chữ số chẵn.
    //Hãy kiểm tra xem số đó có phải là số ưu thế (chẵn hoặc lẻ) hay không. Chú ý: trường hợp số lượng chữ số chẵn và số lượng chữ số lẻ bằng nhau thì không được coi là số ưu thế.
    //Dữ liệu vào
    //Dòng đầu ghi số bộ test, không quá 10
    //Mỗi bộ test là một dãy ký tự có độ dài không quá 1000, không có khoảng trống
    //Kết quả:
    //Nếu dữ liệu vào không phải là một số nguyên hợp lệ (có ký tự không phải số hoặc bắt đầu bằng chữ số 0) thì in ra INVALID
    //Nếu dữ liệu vào thỏa mãn là số ưu thế thì in ra YES, nếu không in ra NO
    //Ví dụ
    //Input:
    //INVALID
    //YES
    //NO
    //Output:
    //3
    //01234aa32432432432534545b987978
    //1234567890123456789000
    //999999999999999999999999999999
    public static int check(String s) {
        if (s.charAt(0) == '0') {
            return -1;
        }
        int even = 0, odd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return -1;
            }
            if ((s.charAt(i) - '0') % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if ((s.length() % 2 == 0 && even > odd) || (s.length() % 2 == 1 && odd > even)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (check(s) == -1) {
                System.out.println("INVALID");
            } else if (check(s) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
