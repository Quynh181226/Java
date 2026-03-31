package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util;

import java.util.Scanner;

public class IMethod {
    public static Scanner scanner = new Scanner(System.in);

    public static int getNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a number.");
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}