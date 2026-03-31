package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Validator;

import java.sql.SQLException;

public class RegisterView {
    private AuthService authService;

    public RegisterView() {
        this.authService = new AuthService();
    }

    public User showRegister() {
        System.out.println("\nRegister new Account - - - - -");

        String fullName = Console.inputString("Enter full name: ");

        String email = Console.inputString("Enter email: ", Validator::isValidEmail, "Email khong dung dinh dang");

        while (true) {
            try {
                if (authService.checkUserExists(email)) {
                    Console.printError("Email da duoc dang ky");
                    email = Console.inputString("Enter email: ",
                            Validator::isValidEmail,
                            "Email khong dung dinh dang");
                    continue;
                }
                break;
            } catch (SQLException e) {
                Console.printError("Database error: " + e.getMessage());
                return null;
            }
        }

        String password = Console.inputString("Enter password: ", Validator::isStrongPassword, "Mat khau phai co it nhat 6 ky tu");

        String confirmPassword = Console.inputString("Re-enter password: ");

        while (!password.equals(confirmPassword)) {
            Console.printError("Mat khau xac nhan khong khop");
            confirmPassword = Console.inputString("Re-enter password: ");
        }

        String phone = Console.inputString("Enter phone number: ",
                Validator::isValidPhone,
                "So dien thoai khong dung dinh dang");

        String address = Console.inputString("Enter address: ");

        try {
            boolean success = authService.register(fullName, email, password, confirmPassword, phone, address);
            if (success) {
                Console.printSuccess("- - - - - Register success!!");
                Console.printInfo("Please login to continue...\n");

                LoginView loginView = new LoginView();
                return loginView.showLogin();
            }
        } catch (SQLException e) {
            Console.printError("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Console.printError(e.getMessage());
        }
        return null;
    }
}