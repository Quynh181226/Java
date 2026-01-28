package JavaCore.Ss4;

//Thẻ thư viện mới của trường có quy định nghiêm ngặt về định dạng
//
//Yêu cầu:
//Viết biểu thức chính quy (Regex) để kiểm tra mã thẻ nhập vào:
//Mã thẻ phải bắt đầu bằng 2 chữ cái viết hoa (ví dụ: TV - Thư Viện)
//Tiếp theo là 4 chữ số năm vào học (ví dụ: 2023)
//Kết thúc bằng 5 ký tự số ngẫu nhiên
//Thông báo lỗi cụ thể nếu người dùng nhập sai định dạng (ví dụ: "Năm không hợp lệ" hoặc "Thiếu tiền tố TV")
public class B4 {
    public static void main(String[] args) {

        String cardID = "TV202312345";

        if(checkCard(cardID)){
            System.out.println("Hop Le");
        }else{
            System.out.println("Invalid");
        }
    }


    public static boolean checkCard(String code){
        if(code == null) return false;
        if(!code.matches("^[A-Z]{2}.*")) return false;
        int year = Integer.parseInt(code.substring(2,6));
        if(year < 2000 || year > 9999) return false;
        return code.matches("^[A-Z]{2}\\d{4}\\d{5}$");
    }
}
