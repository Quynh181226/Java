package JavaCore.Ss4;

//Một thư viện cần số hóa danh mục sách cũ. Dữ liệu nhập vào từ nhân viên thường không đồng nhất (thừa dấu cách, chữ hoa chữ thường lộn xộn). Sinh viên cần viết một chương trình để kiểm chuẩn (Validate) và định dạng lại (Format) thông tin trước khi lưu vào cơ sở dữ liệu
//
//3. Bài tập thực hành
//Phần 1: Kiểm tra định dạng bằng Regex
//Xây dựng các bộ lọc để kiểm tra dữ liệu đầu vào:
//Mã sách (Book ID): Phải có định dạng LIB-xxxx-S (trong đó xxxx là 4 chữ số)
//Mã ISBN: Chấp nhận định dạng ISBN-10 (chỉ gồm 10 chữ số)
//Năm xuất bản: Phải là 4 chữ số và không lớn hơn năm hiện tại (2026)
//
//Phần 2: Chuẩn hóa tiêu đề và tác giả
//Giả sử tên sách nhập vào là: " lập trình jaVa căn bản "
//Sử dụng trim() và split("\\s+") để tách các từ.
//Viết hoa chữ cái đầu tiên của mỗi từ, các chữ cái còn lại viết thường.
//Kết quả mong muốn: "Lập Trình Java Căn Bản"
//
//Phần 3: Tạo chuỗi trích dẫn bằng StringBuilder
//Viết phương thức tạo một chuỗi "Thông tin đầy đủ" để in tem nhãn theo cấu trúc: [Mã Sách] - [Tên Sách] - [Tác Giả] (Năm XB)
//Yêu cầu: Sử dụng StringBuilder để nối các thành phần này thay vì dùng toán tử +. Giải thích ngắn gọn tại sao cách này tối ưu hơn về bộ nhớ
public class Btth {
}
