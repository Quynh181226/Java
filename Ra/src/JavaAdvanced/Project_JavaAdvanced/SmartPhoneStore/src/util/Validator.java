package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) return false;
        return Pattern.matches("^(0[3|5|7|8|9])+([0-9]{8})$", phone);
    }

    public static boolean isStrongPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidPrice(double price) {
        return price >= 0;
    }

    public static boolean isValidStock(int stock) {
        return stock >= 0;
    }
}