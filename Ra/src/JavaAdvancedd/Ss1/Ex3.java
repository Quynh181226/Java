package JavaAdvancedd.Ss1;

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
