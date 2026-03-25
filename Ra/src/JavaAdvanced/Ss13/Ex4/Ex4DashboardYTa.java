package JavaAdvanced.Ss13.Ex4;

import JavaAdvanced.Ss13.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * BÀI TẬP 4 - GIỎI: Giải cứu Dashboard Y tá tại Rikkei Hospital (Vấn đề N+1 Query)
 *
 * PHẦN 1 - Phân tích Input / Output
 * Input : Không tham số (hoặc có thể mở rộng thêm điều kiện ngày, khoa)
 * Output: List<BenhNhanDTO>
 *         Mỗi BenhNhanDTO chứa thông tin cơ bản bệnh nhân và List<DichVu> dsDichVu (có thể rỗng)
 *
 * PHẦN 2 - Đề xuất 2 giải pháp
 * Giải pháp 1 (Multiple Queries - N+1 Query):
 *   - Query 1: SELECT danh sách bệnh nhân
 *   - Với mỗi bệnh nhân lại query riêng: SELECT dịch vụ WHERE maBenhNhan = ?
 *   => Tổng cộng 1 + N query
 *
 * Giải pháp 2 (Single Query với LEFT JOIN + gom nhóm trên Java):
 *   - Chỉ dùng 1 câu SQL duy nhất với LEFT JOIN
 *   - Sử dụng Map<Integer, BenhNhanDTO> để gộp dữ liệu trên Java
 *
 * PHẦN 3 - So sánh & Lựa chọn
 * Tiêu chí                         Giải pháp 1 (N+1)           Giải pháp 2 (LEFT JOIN)
 * Số lượng query / connection      1 + N (rất cao)             Chỉ 1 query
 * Network I/O với Database         Cao                         Thấp
 * Hiệu năng với 500 bệnh nhân      Rất chậm (10-15 giây)       Nhanh (< 1 giây)
 * Độ phức tạp xử lý trên Java      Thấp                        Trung bình
 * Độ dễ viết và bảo trì code       Dễ                          Dễ (code rõ ràng)
 * Xử lý bệnh nhân chưa có dịch vụ  Có thể                      Tốt nhờ left join
 *
 * Kết luận: Chọn Giải pháp 2 vì đáp ứng được Bẫy 1 (Response Time < 1 giây)
 * và Bẫy 2 (vẫn hiển thị bệnh nhân chưa có dịch vụ).
 *
 * PHẦN 4 - Thiết kế
 * Sql: Sử dụng left join để lấy bệnh nhân + dịch vụ trong 1 query
 * Các bước trên Java:
 *   1. Thực thi 1 câu sql với left join
 *   2. Duyệt ResultSet
 *   3. Dùng LinkedHashMap để nhóm theo maBenhNhan
 *   4. Với mỗi dòng: tạo hoặc lấy Dto, sau đó thêm dịch vụ nếu có
 */
public class Ex4DashboardYTa {

    public List<BenhNhanDTO> getDashboardCapCuu() {
        Map<Integer, BenhNhanDTO> mapBenhNhan = new LinkedHashMap<>();

        String sql = """
            SELECT 
                bn.maBenhNhan, 
                bn.hoTen, 
                bn.ngayNhapVien,
                dv.maDichVu, 
                dv.tenDichVu, 
                dv.thoiGianSuDung
            FROM BenhNhan bn
            LEFT JOIN DichVuSuDung dv ON bn.maBenhNhan = dv.maBenhNhan
            WHERE bn.trangThai = 'DangNam' AND bn.khoa = 'CapCuu'
            ORDER BY bn.maBenhNhan, dv.thoiGianSuDung ASC
            """;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maBN = rs.getInt("maBenhNhan");
                String hoTen = rs.getString("hoTen");
                String ngayNhap = rs.getString("ngayNhapVien");

                BenhNhanDTO dto = mapBenhNhan.computeIfAbsent(maBN,
                        k -> new BenhNhanDTO(maBN, hoTen, ngayNhap));


                int maDV = rs.getInt("maDichVu");
                if (!rs.wasNull()) {
                    String tenDV = rs.getString("tenDichVu");
                    String thoiGian = rs.getString("thoiGianSuDung");
                    dto.addDichVu(new DichVu(maDV, tenDV, thoiGian));
                }
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy dữ liệu Dashboard: " + e.getMessage());
        }

        return new ArrayList<>(mapBenhNhan.values());
    }

    public static void main(String[] args) {
        Ex4DashboardYTa service = new Ex4DashboardYTa();
        List<BenhNhanDTO> dashboard = service.getDashboardCapCuu();

        System.out.println("Số bệnh nhân trên Dashboard: " + dashboard.size());
        for (BenhNhanDTO bn : dashboard) {
            System.out.println("Bệnh nhân: " + bn.getHoTen()
                    + " - Số dịch vụ: " + bn.getDsDichVu().size());
        }
    }
}