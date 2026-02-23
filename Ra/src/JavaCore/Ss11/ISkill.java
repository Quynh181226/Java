package JavaCore.Ss11;
/**
 * INTERFACE ISKILL - ĐỊNH NGHĨA NĂNG LỰC ĐẶC BIỆT
 * * 1. YÊU CẦU TƯ DUY PHÂN TÍCH:
 * - Yêu cầu: Tạo một "bản hợp đồng" về hành vi sử dụng chiêu cuối cho nhân vật.
 * - Tư duy: Tách biệt hành động đặc biệt khỏi bản chất của nhân vật. Không phải
 * ai cũng có kỹ năng này (ví dụ: Quái vật thường không có).
 * - Triển khai: Sử dụng phương thức trừu tượng để bắt buộc các lớp con thực thi.
 */
public interface ISkill {
    // Phương thức trừu tượng: Định nghĩa hành vi sử dụng chiêu cuối
    // Độ phức tạp: O(1)
    void useUltimate(GameCharacter target);
}