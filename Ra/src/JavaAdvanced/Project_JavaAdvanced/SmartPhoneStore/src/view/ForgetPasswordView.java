package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;

import java.sql.SQLException;

public class ForgetPasswordView {
    private AuthService authService;

    public ForgetPasswordView() {
        this.authService = new AuthService();
    }
//Pass chưa change thành công
    public void showForgetPassword() {
        System.out.println("Forget Password - - - - ");
        String email = Console.inputString("Enter email: ");
//        String phone = Console.inputString("Enter phone number: ");

//        if (!Validator.isValidPhone(phone)) {
//            Console.printError("Phone number invalid !");
//            return;
//        }

        try {
            if (authService.checkUserExists(email)) {
                String newPassword = Console.inputString("Enter new password: ");
                String confirmPassword = Console.inputString("Re-enter password: ");

                if (!newPassword.equals(confirmPassword)) {
                    Console.printError("Re-password not match !!");
                    return;
                }

                if (authService.updatePassword(email, newPassword)) {
                    System.out.println("Change password success !! - - - -");
                } else {
                    Console.printError("Change password failed !!");
                }
            } else {
                Console.printError("Email or phone number is incorrect !!");
            }
        } catch (SQLException e) {
            Console.printError("Database error: " + e.getMessage());
        }
    }
}