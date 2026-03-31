package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.view;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service.AuthService;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.User;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Console;

public class Home {
    private static AuthService authService = new AuthService();
    private static User currUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("|     WELCOME TO SHOP : SMARTPHONE STORE                                                             |");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━ HOME PAGE ━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                      ┃                        ┃                           ┃                        ┃");
            System.out.println("┃     1. REGISTER      ┃        2. LOGIN        ┃     3. FORGET PASSWORD    ┃        4. EXIT         ┃");
            System.out.println("┃                      ┃                        ┃                           ┃                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┛");

            int choice = Console.inputInt("Lua chon cua ban: ");

            switch (choice) {
                case 1:
                    RegisterView r = new RegisterView();
                    currUser=r.showRegister();

                    if(currUser!=null){
                        if(currUser.getRole().equals("Admin")){
                            new AdminView().showMenu(currUser);
                        }else {
                            new CustomerView().showMenu(currUser);
                        }
                        currUser=null;
                    }
                    break;
                case 2:
                    LoginView l=new LoginView();
                    currUser=l.doLogin();

                    if (currUser != null) {
                        if (currUser.getRole().equalsIgnoreCase("Admin")) {
                            new AdminView().showMenu(currUser);
                        } else {
                            new CustomerView().showMenu(currUser);
                        }

                        currUser = null;
                    }
                    break;
                case 3:
                    new ForgetPasswordView().showForgetPassword();
                    break;
                case 4:
                    System.out.println("Goodbye !!!");
                    return;
                default:
                    System.err.println("Enter choice from 1 to 5 !!");
            }
        }
    }
}