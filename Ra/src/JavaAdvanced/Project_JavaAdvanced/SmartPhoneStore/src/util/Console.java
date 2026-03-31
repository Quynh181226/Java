package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util;

import java.util.Scanner;
import java.util.function.Predicate;

import static JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util.Color.*;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void printSuccess(String message) {
        System.out.println(GREEN + message + RESET);
    }

    public static void printError(String message) {
        System.out.println(RED + "Err: " + message + RESET);
    }

    public static void printInfo(String message) {
        System.out.println(BLUE + message + RESET);
    }

    public static void printInfo1(String message) {
        System.out.print(BLUE + message + RESET);
    }

    public static void printSeparator() {
        System.out.println(CYAN + "-----------------------------------" + RESET);
    }

    public static void printBox(String... lines) {
        System.out.println(CYAN + "┌────────────────────────────────────────────────────────────────────────┐" + RESET);
        for (String line : lines) {
            System.out.printf(CYAN + "│" + RESET + " %-70s " + CYAN + "│" + RESET + "%n", line);
        }
        System.out.println(CYAN + "└────────────────────────────────────────────────────────────────────────┘" + RESET);
    }

    public static String getStatusText(String status) {
        return switch (status.toLowerCase()) {
            case "pending" -> "Cho xu ly";
            case "shipping" -> "Dang giao";
            case "delivered" -> "Da giao";
            case "cancelled" -> "Da huy";
            default -> status;
        };
    }

    public static String inputString(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(CYAN + prompt + RESET);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                printError("Không được để trống!");
                continue;
            }

            if (validator.test(input)) {
                return input;
            }

            printError(errorMessage);
        }
    }

    public static String inputString(String prompt) {
        return inputString(prompt, s -> true, "");
    }

    public static int inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                printError("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static double inputDouble(String prompt) {
        while (true) {
            try {
                System.out.print(CYAN + prompt + RESET);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                printError("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static boolean inputBoolean(String prompt) {
        while (true) {
            System.out.print(CYAN + prompt + RESET);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes") || input.equals("1")) return true;
            if (input.equals("n") || input.equals("no") || input.equals("0")) return false;
            printError("Vui lòng nhập y/n hoặc 1/0!");
        }
    }

    public static String inputStringAllowEmpty(String prompt) {
        System.out.print(CYAN + prompt + RESET);
        return scanner.nextLine().trim();
    }

    public static String inputCapacity(String prompt, int minGB, int maxGB) {
        while (true) {
            System.out.print(CYAN + prompt + RESET);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                printError("Không được để trống!");
                continue;
            }

            try {
                int capacity = Integer.parseInt(input);

                if (capacity < minGB) {
                    printError("Dung lượng tối thiểu là " + minGB + "GB!");
                    continue;
                }
                if (capacity > maxGB) {
                    printError("Dung lượng tối đa là " + maxGB + "GB!");
                    continue;
                }

                return capacity + "GB";

            } catch (NumberFormatException e) {
                printError("Vui lòng nhập số nguyên hợp lệ (ví dụ: 128, 256, 512)!");
            }
        }
    }
}