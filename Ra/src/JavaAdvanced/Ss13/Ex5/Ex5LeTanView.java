package JavaAdvanced.Ss13.Ex5;

import java.util.List;
import java.util.Scanner;

/*
 * BÀI TẬP XUẤT SẮC - MODULE "TIẾP NHẬN NỘI TRÚ 1 CHẠM" TẠI RIKKEI HOSPITAL
 *
 * PHẦN 1 - Phân tích Rủi ro & Bẫy lỗi (Edge Cases)
 * 1. Nhân viên nhập sai định dạng số (ví dụ: gõ chữ "Năm trăm" hoặc "abc" vào ô tiền tạm ứng hoặc tuổi)
 *    -> Sẽ gây NumberFormatException, nếu không catch sẽ làm crash toàn bộ chương trình.
 * 2. Mã giường nhập vào không tồn tại hoặc đang ở trạng thái 'Đã có người'
 *    -> Câu UPDATE giường trả về rowsAffected = 0 -> Nếu không kiểm tra sẽ gây sai dữ liệu (bệnh nhân được tạo nhưng giường không được chiếm).
 * 3. Lỗi kết nối mạng / SQLException xảy ra ở giữa transaction
 *    (đã INSERT bệnh nhân thành công nhưng chưa UPDATE giường và chưa INSERT tiền)
 *    -> Nếu không rollback, bệnh nhân tồn tại nhưng không có giường và tiền không được ghi nhận → đúng với nỗi đau của khách hàng.
 *
 * PHẦN 2 - Thiết kế Kiến trúc (Architecture & Data Flow)
 * Chức năng Tiếp nhận bệnh nhân (Core Feature) - 3 thao tác trong 1 Transaction:
 *   Bước 1: conn.setAutoCommit(false)
 *   Bước 2: INSERT INTO BenhNhan -> lấy maBenhNhan được sinh tự động
 *   Bước 3: UPDATE GiuongBenh SET trangThai = 'Đã có người' WHERE maGiuong = ? AND trangThai = 'Trống'
 *   Bước 4: INSERT INTO TamUng (maBenhNhan, soTienTamUng, ngayThu) VALUES (?, ?, GETDATE())
 *   Bước 5: Nếu tất cả thành công -> conn.commit()
 *   Bước 6: Catch bất kỳ Exception -> conn.rollback() + thông báo thân thiện
 *   Bước 7: Finally → khôi phục autoCommit = true và đóng connection
 */
public class Ex5LeTanView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BenhNhanController controller = new BenhNhanController();

        System.out.println("========================================");
        System.out.println("   TIẾP NHẬN NỘI TRÚ 1 CHẠM - RIKKEI HOSPITAL");
        System.out.println("========================================");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Xem tình trạng giường bệnh (Trống)");
            System.out.println("2. Tiếp nhận bệnh nhân nội trú");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.println("\nDANH SÁCH GIƯỜNG TRỐNG:");
                        List<String> giuongTrong = controller.xemGiuongTrong();
                        if (giuongTrong.isEmpty()) {
                            System.out.println("Hiện không còn giường trống.");
                        } else {
                            giuongTrong.forEach(System.out::println);
                        }
                        break;

                    case 2:
                        System.out.println("\n--- TIẾP NHẬN BỆNH NHÂN ---");
                        System.out.print("Nhập tên bệnh nhân: ");
                        String ten = scanner.nextLine().trim();

                        System.out.print("Nhập tuổi: ");
                        int tuoi = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Nhập mã giường: ");
                        int maGiuong = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Nhập số tiền tạm ứng (VND): ");
                        double soTien = Double.parseDouble(scanner.nextLine().trim());

                        controller.tiepNhanBenhNhan(ten, tuoi, maGiuong, soTien);
                        break;

                    case 3:
                        System.out.println("Đã thoát chương trình. Hẹn gặp lại!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng chỉ nhập số hợp lệ!");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}