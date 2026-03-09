package JavaAdvanced.Ss1;
//Xây dựng lớp User với thuộc tính age. Trong quá trình thiết lập dữ liệu ( phương thức setter ), chúng ta cần đảm bảo tuổi không được vi phạm quy tắc nghiệp vụ ( tuổi không thể âm )
//Yêu cầu
//Tạo phương thức public void setAge(int age)
//Sử dụng lệnh if để kiểm tra: Nếu age < 0, hãy sử dụng từ khóa throw để ném ra 1 đối tượng IllegalArgumentException với thông báo "Tuổi không thể âm!"
//Gán giá trị nếu dữ liệu hợp lệ
//3. Kết quả mong muốn:
//Phương thức setAge từ chối lưu giá trị âm và lập tức ném ra ngoại lệ có ý nghĩa rõ ràng, giúp ngăn chặn lỗi lan truyền sai lệch trong hệ thống
public class Ex3 {
    public static class User {
        int age;




        public void setAge(int age) {


            if(age < 0){
                throw new IllegalArgumentException("Tuổi không thể âm!");
            }

            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {

        User user = new User();


        try{
            user.setAge(-5);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("..");
    }
}
