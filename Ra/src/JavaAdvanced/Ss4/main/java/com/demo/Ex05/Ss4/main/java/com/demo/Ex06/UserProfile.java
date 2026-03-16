package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.main.java.com.demo.Ex06;

import java.time.LocalDate;

public class UserProfile {

    private String email;
    private LocalDate birthDate;

    public UserProfile(String email, LocalDate birthDate) {
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
