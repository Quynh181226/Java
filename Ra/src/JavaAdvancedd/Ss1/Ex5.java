package JavaAdvancedd.Ss1;

public class Ex5 {
    public static class User {

        private int age;

        public void setAge(int age) throws CustomException {

            if (age < 0) {
                throw new CustomException("Tuổi không thể âm!");
            }

            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static class CustomException extends Exception {

        public CustomException(String msg){
            super(msg);
        }



    }

    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-10);
        } catch (CustomException e) {
            System.out.println("Lỗi nghiệp vụ: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
