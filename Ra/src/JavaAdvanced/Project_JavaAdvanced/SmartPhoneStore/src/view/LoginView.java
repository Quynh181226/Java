package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;
import java.sql.SQLException;

public class LoginView {
    private AuthService authService;

    public LoginView() {
        this.authService = new AuthService();
    }

    public User showLogin() {
        System.out.println("""
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        |                                                         Page : Login                                                      |
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃                              ┃                              ┃                              ┃                              ┃
        ┃         1. Login             ┃         2. Register          ┃      3. Forget Password      ┃           4 . Exit           |
        ┃                              ┃                              ┃                              ┃                              ┃
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        int choice = Console.inputInt("Lua chon cua ban: ");

        switch (choice) {
            case 1 -> {
                User user = doLogin();
                if (user != null) {
                    return user;
                }
            }

            case 2 -> {
                RegisterView registerView = new RegisterView();
                registerView.showRegister();
                return null;
            }

            case 3 -> {
                ForgetPasswordView forgetView = new ForgetPasswordView();
                forgetView.showForgetPassword();
                return null;
            }

            case 4 -> {
                return null;
            }

            default -> {
                Console.printError("Lua chon khong hop le !!");
                return null;
            }
        }
        return null;
        //C:\Users\TDG\Desktop\Java\SmartPhoneStore\src\view\LoginView.java:48:5
        //java: missing return statement
    }

    public User doLogin() {
        String email = Console.inputString("Enter email: ");
        String password = Console.inputString("Enter password: ");

        try {
            User user = authService.login(email, password);
            if (user != null) {
                System.out.println("Login success !!");
                return user;
            }
        } catch (SQLException e) {
            Console.printError("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Console.printError(e.getMessage());
        }
        return null;
    }
}