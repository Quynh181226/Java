package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.main.java.com.demo;

public class Ex01 {
    public boolean isValidUsername(String username){
        if(username == null){
            return false;
        }

        if(username.length() < 6 || username.length() > 20){
            return false;
        }

        if(username.contains(" ")){
            return false;
        }

        return true;
    }
}
