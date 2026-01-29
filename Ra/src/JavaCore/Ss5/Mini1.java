package JavaCore.Ss5;

import java.util.Scanner;

public class Mini1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Nhap lua chon (1-5 hoac 0 de thoat): ");

            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le! Vui long nhap so.");
                // bo input fail
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            // consume newline
            sc.nextLine();

//            if (choice == 0) {
//                System.out.println("Tam biet! Hen gap lai.");
//                break;
//            }

            switch (choice) {
                case 0:
                    System.out.println("Tam biet! Hen gap lai.");
                    return;
//                  break;
                case 1:
                    twoSum(sc);
                    break;
                case 2:
                    moveZeroes(sc);
                    break;
                case 3:
                    validPalindrome(sc);
                    break;
                case 4:
                    reverseWords(sc);
                    break;
                case 5:
                    happyNumber(sc);
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=====================================");
        System.out.println("     MINI PROJECT - THUAT TOAN CO BAN    ");
        System.out.println("=====================================");
        System.out.println("1. Two Sum (Tim cap so co tong = target)");
        System.out.println("2. Move Zeroes (Don so 0 ve cuoi mang)");
        System.out.println("3. Valid Palindrome (Kiem tra chuoi doi xung)");
        System.out.println("4. Reverse Words in a String (Dao nguoc tu trong cau)");
        System.out.println("5. Happy Number (So hanh phuc)");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("=====================================");
    }

    private static void twoSum(Scanner sc) {
        System.out.println("\n=== Two Sum ===");
        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println("Mang phai co it nhat 2 phan tu.");
            return;
        }

        int[] nums = new int[n];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Nhap target: ");
        int target = sc.nextInt();

        // Check tung pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.printf("Tim thay cap: index %d va %d (%d + %d = %d)\n", i, j, nums[i], nums[j], target);
                    return;
                }
            }
        }

        System.out.println("Khong tim thay cap so nao co tong bang " + target);
    }

    private static void moveZeroes(Scanner sc) {
        System.out.println("\n=== Move Zeroes (Cach de nhat) ===");
        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Mang rong.");
            return;
        }

        int[] nums = new int[n];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }

        System.out.print("Mang sau khi don 0 ve cuoi: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void validPalindrome(Scanner sc) {
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Chuoi rong -> True");
            return;
        }

        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = new StringBuilder(cleaned).reverse().toString();

        boolean isPalindrome = cleaned.equals(reversed);

        System.out.println("Ket qua: " + (isPalindrome ? "True" : "False"));
        System.out.println("(Sau khi lam sach: " + cleaned + ")");
    }

    private static void reverseWords(Scanner sc) {
        System.out.println("\n=== Reverse Words in a String ===");
        System.out.print("Nhap cau: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Chuoi rong -> \"\"");
            return;
        }

        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        System.out.println("Ket qua: \"" + result.toString() + "\"");
    }

    private static void happyNumber(Scanner sc) {
        System.out.println("\n=== Happy Number (Dung mang boolean danh dau) ===");
        System.out.print("Nhap so nguyen duong n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("So phai lon hon 0.");
            return;
        }

        boolean[] seen = new boolean[1000];

        int current = n;
        boolean isHappy = false;


        while (current != 1) {
            if (seen[current]) {
                break;
            }

            seen[current] = true;

            current = sumOfSquareDigits(current);
        }

        if (current == 1) {
            isHappy = true;
        }

        System.out.println(isHappy
                ? "True - Day la so hanh phuc"
                : "False - Khong phai so hanh phuc (vao vong lap)");
    }

    private static int sumOfSquareDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}