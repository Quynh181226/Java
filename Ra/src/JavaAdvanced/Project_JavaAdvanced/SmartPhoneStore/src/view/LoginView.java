package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;
import java.sql.SQLException;

public class LoginView {
    private AuthService authService;

    public LoginView() {
        this.authService = new AuthService();
    }

    public User showLogin() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("|                                                         PAGE : LOGIN                                                      |");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                              ┃                              ┃                              ┃                              ┃");
        System.out.println("┃         1. Login             ┃         2. Register          ┃      3. Forget password      ┃           4 . EXIT           |");
        System.out.println("┃                              ┃                              ┃                              ┃                              ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        int choice = Console.inputInt("Lua chon cua ban: ");

        switch (choice) {
            case 1:
//                return doLogin();
                User user = doLogin();
                if (user != null) {
                    return user;
                }
                break;
            case 2:
                RegisterView registerView = new RegisterView();
                registerView.showRegister();
                return null;
            case 3:
                ForgetPasswordView forgetView = new ForgetPasswordView();
                forgetView.showForgetPassword();
                return null;
            case 4:
                return null;
            default:
                Console.printError("Enter choice from 1 to 4 !");
                return null;
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