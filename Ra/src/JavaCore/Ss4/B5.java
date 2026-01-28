package JavaCore.Ss4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Hệ thống thư viện xuất ra một file log dạng text thuần có cấu trúc như sau: 2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345
//
//Yêu cầu:
//Sử dụng Regex với các "Capturing Groups" để tách riêng: Ngày tháng, Tên người dùng, Hành động, và Mã sách
//Lưu trữ các thông tin này vào các biến riêng biệt
//Thống kê xem trong file log có bao nhiêu hành động "BORROW" (Mượn) và bao nhiêu hành động "RETURN" (Trả)
public class B5 {
    private static final String LOG_REGEX = "(\\d{4}-\\d{2}-\\d{2})\\s*\\|\\s*User:\\s*([A-Za-z0-9_]+)\\s*\\|\\s*Action:\\s*(BORROW|RETURN)\\s*\\|\\s*BookID:\\s*(BK\\d+)";

    public static void main(String[] args) {
        String Log = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345";

        Pattern pattern = Pattern.compile(LOG_REGEX);
        Matcher matcher = pattern.matcher(Log);

        if (matcher.matches()) {
            String date = matcher.group(1);
            String user = matcher.group(2);
            String action = matcher.group(3);
            String bookId = matcher.group(4);

            System.out.println("Ngày: " + date);
            System.out.println("Người dùng: " + user);
            System.out.println("Hành động: " + action);
            System.out.println("Mã sách: " + bookId);
        } else {
            System.out.println("Dòng log không hợp lệ");
        }
}
}
