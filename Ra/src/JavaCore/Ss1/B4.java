package JavaCore.Ss1;

import java.util.Scanner;

//Thư viện nhập sách từ Mỹ, cần tính toán giá từ USD sang VNĐ và làm tròn
//
//Yêu cầu:
//Nhập giá sách kiểu double (VD: 25.5 USD) và tỷ giá kiểu float (VD: 25450.0)
//Tính tổng tiền VNĐ = Giá sách * Tỷ giá
//Ép kiểu kết quả từ double sang long để có số tiền chẵn và in ra màn hình
//
//3. Kết quả mong muốn
//(Lưu ý: Giá trị có thể khác khi tỷ giá khác nhau)
public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập giá sách (USD): ");
        double price=sc.nextDouble();

        System.out.print("Nhập tỷ giá (VND): ");
        float exchangeRate=sc.nextFloat();

        double totalPrice=price*exchangeRate;
        long pay=(long)totalPrice;

        System.out.print("Giá chính xác (Số thực): "+totalPrice);
        System.out.print("\nGiá làm trong để thanh toán (long): "+pay);
    }
}
