package Ss2;
//2. Mô tả
//Bạn cần viết một chương trình cho phép thủ thư thực hiện 3 chức năng chính: tính tiền phạt trả muộn, kiểm tra điều kiện mượn sách đặc biệt, và thống kê nhanh hiệu suất ngày làm việc
//
//3. Bài tập thực hành
//Chức năng 1: Tính tiền phạt trả sách (Sử dụng For)
//Yêu cầu nhập số lượng sách độc giả trả
//Với mỗi cuốn, nhập số ngày quá hạn
//Công thức: * Trễ từ 1 - 5 ngày: 2.000 VNĐ/ngày
//Trễ trên 5 ngày: 5.000 VNĐ/ngày (cho các ngày từ ngày thứ 6 trở đi)
//In ra tổng tiền phạt của độc giả đó
//
//Chức năng 2: Đăng ký thẻ mượn sách VIP (Sử dụng If-Else & Toán tử điều kiện)
//Nhập tuổi và số sách đã mượn trong tháng qua
//Điều kiện VIP: Tuổi >= 18 và đã mượn >= 10 cuốn sách, HOẶC là sinh viên có thẻ ưu tiên (nhập 1 là có, 0 là không)
//In ra kết quả "Đủ tiêu chuẩn nâng cấp VIP" hoặc "Chưa đủ tiêu chuẩn"
//
//Chức năng 3: Thống kê số sách nhập kho (Sử dụng Do-While & Break/Continue)
//Thủ thư nhập mã số các cuốn sách mới về kho
//Nếu nhập mã số âm: Yêu cầu nhập lại (Sử dụng continue)
//Nếu nhập mã số 0: Dừng việc nhập kho (Sử dụng break)
//Sau khi kết thúc, in ra tổng số lượng sách hợp lệ đã nhập vào
public class Btth {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ THƯ VIỆN ===");
            System.out.println("1. Tính tiền phạt trả sách muộn");
            System.out.println("2. Đăng ký thẻ mượn sách VIP");
            System.out.println("3. Thống kê số sách nhập kho mới");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng (0-3): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    calculateLateFine(sc);
                    break;
                case 2:
                    registerVIPCard(sc);
                    break;
                case 3:
                    countNewBooks(sc);
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void calculateLateFine(java.util.Scanner sc) {
        System.out.print("Nhập số lượng sách độc giả trả: ");
        int numberOfBooks = sc.nextInt();
        if (numberOfBooks <= 0) {
            System.out.println("Số lượng sách không hợp lệ.");
            return;
        }
        long totalFine = 0;
        for (int i = 1; i <= numberOfBooks; i++) {
            System.out.print("Nhập số ngày quá hạn của cuốn sách thứ " + i + ": ");
            int daysOverdue = sc.nextInt();
            if (daysOverdue <= 0) continue;
            long fineForBook = (daysOverdue <= 5) ? daysOverdue * 2000L : 5 * 2000L + (daysOverdue - 5) * 5000L;
            totalFine += fineForBook;
        }
        System.out.println("Tổng tiền phạt của độc giả: " + totalFine + " VNĐ");
    }

    private static void registerVIPCard(java.util.Scanner sc) {
        System.out.print("Nhập tuổi của bạn: ");
        int age = sc.nextInt();
        System.out.print("Số sách đã mượn trong tháng qua: ");
        int booksBorrowed = sc.nextInt();
        System.out.print("Có thẻ ưu tiên sinh viên không? (1 = Có, 0 = Không): ");
        int priorityCard = sc.nextInt();

        boolean eligible = (age >= 18 && booksBorrowed >= 10) || (priorityCard == 1);
        System.out.println(eligible ? "Đủ tiêu chuẩn nâng cấp VIP!" : "Chưa đủ tiêu chuẩn nâng cấp VIP.");
    }

    private static void countNewBooks(java.util.Scanner sc) {
        int totalValidBooks = 0;
        int bookCode;
        System.out.println("Nhập mã số các cuốn sách mới về kho (0 để kết thúc, mã âm sẽ yêu cầu nhập lại)");
        do {
            System.out.print("Nhập mã sách: ");
            bookCode = sc.nextInt();
            if (bookCode < 0) continue;
            if (bookCode == 0) break;
            totalValidBooks++;
        } while (true);
        System.out.println("Tổng số sách hợp lệ đã nhập kho: " + totalValidBooks + " cuốn");
    }
}