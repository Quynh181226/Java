package JavaAdvanced.Ss8.Ex1;
//Bài tập Khá: ÁP DỤNG SINGLETON & FACTORY METHOD – QUẢN LÝ KẾT NỐI VÀ TẠO THIẾT BỊ
//Bài tập Khá: ÁP DỤNG SINGLETON & FACTORY METHOD – QUẢN LÝ KẾT NỐI VÀ TẠO THIẾT BỊ
//1. Mục tiêu
//Hiểu và áp dụng Singleton Pattern để quản lý tài nguyên dùng chung.
//Hiểu và áp dụng Factory Method Pattern để tạo đối tượng linh hoạt.
//Thực hành tách biệt quá trình khởi tạo đối tượng khỏi client.
//2. Mô tả
//Bài toán
//Hệ thống điều khiển nhà thông minh cần:
//Một kết nối phần cứng duy nhất (giả lập việc kết nối đến các thiết bị thật). Nếu có nhiều đối tượng kết nối cùng lúc sẽ gây xung đột.
//Tạo ra các thiết bị khác nhau: Đèn (Light), Quạt (Fan), Điều hòa (AirConditioner). Mỗi loại thiết bị có cách khởi tạo riêng. Hiện tại, client đang dùng new trực tiếp, gây khó khăn khi mở rộng.
//Yêu cầu
//Áp dụng Singleton cho lớp HardwareConnection đảm bảo chỉ có một instance duy nhất. Lớp này có phương thức connect() và disconnect() (chỉ in ra console).
//Áp dụng Factory Method để tạo các thiết bị:
//Interface Device với các phương thức turnOn(), turnOff().
//Các lớp cụ thể: Light, Fan, AirConditioner implement Device.
//Tạo abstract class DeviceFactory với phương thức createDevice().
//Các factory con: LightFactory, FanFactory, AirConditionerFactory.
//Viết chương trình console cho phép người dùng:
//Kết nối phần cứng (lấy instance Singleton).
//Tạo thiết bị mới (chọn loại, factory tạo ra device).
//Bật/tắt thiết bị vừa tạo.
//Thoát.
//3. Kết quả mong muốn
//Thao tác
//Input
//Output
//1. Kết nối phần cứng
//(Chọn 1)
//HardwareConnection: Đã kết nối phần cứng. (Chỉ hiện 1 lần duy nhất)
//2. Tạo thiết bị mới
//Chọn loại: 1. Đèn, 2. Quạt, 3. Điều hòa
//Chọn: 1
//LightFactory: Đã tạo đèn mới.
//3. Bật thiết bị
//Chọn thiết bị vừa tạo: 1
//Đèn: Bật sáng.
//4. Tạo thêm thiết bị
//Chọn loại: 2
//FanFactory: Đã tạo quạt mới.
//5. Kiểm tra Singleton
//Gọi kết nối lần 2
//(Không in gì thêm, vẫn dùng instance cũ)
//4. Kết luận
//Hoàn thành chương trình, đảm bảo chỉ một instance HardwareConnection.
//Có thể thêm loại thiết bị mới (ví dụ: Máy lọc không khí) chỉ bằng cách tạo thêm class và factory mới, không sửa code client.
public class Ss8 {
}
