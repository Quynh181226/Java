package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.main.java.com.demo;

public class Ex03 {
    public String processEmail(String email){
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }

        String[] parts = email.split("@");
        if(parts.length != 2 || parts[1].isEmpty()){
            throw new IllegalArgumentException("Invalid email format");
        }

        return email.toLowerCase();
    }
}
