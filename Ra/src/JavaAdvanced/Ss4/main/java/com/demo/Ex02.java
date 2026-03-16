package JavaAdvanced.Ss4.main.java.com.demo;

public class Ex02 {
    public boolean checkRegistrationAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        return age >= 18;
    }
}
