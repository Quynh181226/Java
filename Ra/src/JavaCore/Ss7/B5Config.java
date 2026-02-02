package JavaCore.Ss7;

//1. Mục tiêu
//Hiểu final variable
//Áp dụng hằng số trong chương trình
//2. Mô tả
//Hệ thống cần các giá trị cố định không được thay đổi.
//Yêu cầu:
//Tạo lớp Config
//Khai báo:
//static final cho các hằng số (ví dụ: MAX_SCORE, MIN_SCORE)
//Sử dụng các hằng số này trong chương trình
//Thử thay đổi giá trị và quan sát lỗi biên dịch
//3. Kết quả mong muốn
//Hiểu vì sao final giúp an toàn dữ liệu
//Biết quy ước đặt tên hằng số (IN HOA)

public class B5Config {
    static double MAX_SCORE = 10.0;
    static final double MIN_SCORE = 0.0;
}