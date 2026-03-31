package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.util;

import java.util.Scanner;
import java.util.function.Predicate;

public class Console {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    private static Scanner scanner = new Scanner(System.in);

//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

//    public static void printHeader(String title) {
//        System.out.println(CYAN + BOLD + "╔════════════════════════════════════════════════════════════════════╗" + RESET);
//        System.out.println(CYAN + BOLD + "║" + RESET + "  " + WHITE + BOLD + title + RESET + " ".repeat(70 - title.length()) + CYAN + BOLD + "║" + RESET);
//        System.out.println(CYAN + BOLD + "╚════════════════════════════════════════════════════════════════════╝" + RESET);
//        System.out.println();
//    }
//public static void printHeader(String title) {
//    System.out.println("╔════════════════════════════════════════════════════════════════════╗");
//    System.out.println("║  " + title + " ".repeat(70 - title.length()) + "║");
//    System.out.println("╚════════════════════════════════════════════════════════════════════╝");
    ////    System.out.println();
//}

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

    public static void printWarning(String message) {
        System.out.println(YELLOW + "WARNING: " + message + RESET);
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

//    public static void printTableHeader(String... headers) {
//        System.out.println(CYAN + BOLD + "┌────────────────────────────────────────────────────────────────────────────────┐" + RESET);
//        System.out.print(CYAN + BOLD + "│" + RESET);
//        for (String header : headers) {
//            System.out.printf(" %-20s ", header);
//        }
//        System.out.println(CYAN + BOLD + "│" + RESET);
//        System.out.println(CYAN + BOLD + "├────────────────────────────────────────────────────────────────────────────────┤" + RESET);
//    }

    public static void printTableRow(Object... values) {
        System.out.print(CYAN + "│" + RESET);
        for (Object value : values) {
            System.out.printf(" %-20s ", value != null ? value.toString() : "");
        }
        System.out.println(CYAN + "│" + RESET);
    }

    public static void printTableFooter() {
        System.out.println(CYAN + BOLD + "└────────────────────────────────────────────────────────────────────────────────┘" + RESET);
    }

//    public static String inputString(String prompt) {
//        while (true) {
//            System.out.print(CYAN + prompt + RESET);
//            String input = scanner.nextLine().trim();
//            if (!input.isEmpty()) return input;
//            printError("Khong duoc de trong!!");
//        }
//    }
//
//    public static int inputInt(String prompt) {
//        while (true) {
//            try {
//                System.out.print(prompt);
//                return Integer.parseInt(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                printError("Vui long nhap so hop le!!");
//            }
//        }
//    }
//
//    public static double inputDouble(String prompt) {
//        while (true) {
//            try {
//                System.out.print(CYAN + prompt + RESET);
//                return Double.parseDouble(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                printError("Vui long nhap so hop le!");
//            }
//        }
//    }
//
//    public static boolean inputBoolean(String prompt) {
//        while (true) {
//            System.out.print(CYAN + prompt + RESET);
//            String input = scanner.nextLine().trim().toLowerCase();
//            if (input.equals("y") || input.equals("yes") || input.equals("1")) {
//                return true;
//            } else if (input.equals("n") || input.equals("no") || input.equals("0")) {
//                return false;
//            }
//            printError("Vui long nhap y/n hoac 1/0!");
//        }
//    }

    /**
     * Nhập chuỗi với validate
     * @param prompt Thông báo nhập
     * @param validator Điều kiện hợp lệ (ví dụ: Validator::isValidEmail)
     * @param errorMessage Thông báo lỗi khi sai
     * @return Giá trị hợp lệ
     */
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

    /**
     * Nhập chuỗi thông thường (chỉ không được để trống) - giữ lại để tương thích cũ
     */
    public static String inputString(String prompt) {
        return inputString(prompt, s -> true, "");
    }

    /**
     * Nhập mật khẩu + xác nhận mật khẩu
     */
    public static String inputPasswordWithConfirm() {
        while (true) {
            String password = inputString("Nhập mật khẩu: ",
                    Validator::isStrongPassword,
                    "Mật khẩu phải có ít nhất 6 ký tự!");

            String confirm = inputString("Nhập lại mật khẩu: ");

            if (password.equals(confirm)) {
                return password;
            }

            printError("Mật khẩu xác nhận không khớp!");
        }
    }

    // Giữ lại các hàm cũ để không làm hỏng code khác
    public static int inputInt(String prompt) {
        while (true) {
            try {
//                System.out.print(CYAN + prompt + RESET);
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

    /**
     * Nhập chuỗi, CHO PHÉP để trống (dùng khi update - bỏ trống = giữ nguyên)
     */
    public static String inputStringAllowEmpty(String prompt) {
        System.out.print(CYAN + prompt + RESET);
        return scanner.nextLine().trim();   // cho phép rỗng
    }
    /**
     * Nhập dung lượng (capacity) - chỉ nhận số nguyên, có kiểm tra min/max
     * Tự động thêm "GB" sau khi nhập thành công
     */
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

                return capacity + "GB";   // Tự động thêm GB

            } catch (NumberFormatException e) {
                printError("Vui lòng nhập số nguyên hợp lệ (ví dụ: 128, 256, 512)!");
            }
        }
    }
//}
}