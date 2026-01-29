package JavaCore.Ss5;

import java.util.Scanner;

/**
 * Mini Project: Console App tổng hợp thuật toán cơ bản
 * Áp dụng: biến, điều kiện, vòng lặp, mảng, chuỗi, regex
 */
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

    /**
     * FR1: Two Sum - Tìm cặp số có tổng bằng target
     *
     * Yêu cầu tư duy và phân tích:
     * - Bài toán yêu cầu tìm hai chỉ số i và j trong mảng sao cho arr[i] + arr[j] = target, với i != j.
     * - Tư duy: Cần tránh kiểm tra lặp lại (ví dụ không kiểm tra i > j để tránh trùng lặp cặp).
     * - Phân tích: Mảng có thể có số âm, số trùng nhau, hoặc không có cặp nào. Cần xử lý mảng rỗng hoặc ít hơn 2 phần tử.
     * - Cách giải quyết vấn đề: Sử dụng cách brute force (vòng lặp lồng) để đơn giản, không dùng Map như yêu cầu.
     *   Nếu dùng Map, có thể tối ưu hơn nhưng ở đây dùng cách cơ bản để dễ hiểu.
     *
     * Giải thuật:
     * - Duyệt qua từng phần tử i từ 0 đến n-1.
     * - Với mỗi i, duyệt j từ i+1 đến n-1, kiểm tra nếu arr[i] + arr[j] == target thì in ra và dừng.
     * - Nếu không tìm thấy, thông báo không có.
     * - Đây là giải thuật brute force: Kiểm tra tất cả các cặp có thể.
     *
     * Độ phức tạp:
     * - Thời gian: O(n^2) - xấu nhất khi kiểm tra tất cả cặp (n*(n-1)/2 lần so sánh).
     * - Không gian: O(1) - không dùng bộ nhớ phụ ngoài mảng input.
     * - Đánh giá: Đơn giản, dễ implement, phù hợp mảng nhỏ. Với mảng lớn (n>10^4), nên dùng HashMap để O(n) thời gian.
     * - Ví dụ: Mảng [2,7,11,15], target=9 → cặp index 0 và 1 (2+7=9).
     */
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

    /**
     * FR2: Move Zeroes - Dồn số 0 về cuối mảng
     *
     * Yêu cầu tư duy và phân tích:
     * - Bài toán yêu cầu di chuyển tất cả 0 về cuối mảng mà giữ nguyên thứ tự tương đối của các phần tử khác.
     * - Tư duy: Không dùng mảng phụ, phải modify in-place. Xử lý trường hợp mảng toàn 0, không 0, hoặc rỗng.
     * - Phân tích: Các số không 0 phải dịch chuyển lên đầu, 0 đẩy xuống cuối. Cần tránh copy thừa.
     * - Cách giải quyết vấn đề: Sử dụng kỹ thuật two pointers để hoán đổi vị trí.
     *
     * Giải thuật:
     * - Two pointers: left chỉ vị trí tiếp theo để đặt số không 0, right duyệt toàn mảng.
     * - Khi right gặp số !=0, hoán đổi với left và tăng left.
     * - Kết quả: Phần đầu là số !=0 (giữ thứ tự), phần cuối là 0.
     *
     * Độ phức tạp:
     * - Thời gian: O(n) - duyệt mảng một lần.
     * - Không gian: O(1) - chỉ dùng biến phụ.
     * - Đánh giá: Tối ưu, hiệu quả cao. So với cách đếm số không 0 rồi copy, cách này đơn giản hơn.
     * - Ví dụ: Mảng [0,1,0,3,12] → [1,3,12,0,0].
     */
    private static void moveZeroes(Scanner sc) {
        System.out.println("\n=== Move Zeroes ===");
        System.out.print("Nhap so phan tu cua mang: ");
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

        // Two pointers: left là vị trí tiếp theo để đặt số !=0
        // Hoán đổi nums[left] và nums[right]
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }

        System.out.print("Mang sau khi don 0 ve cuoi: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * FR3: Valid Palindrome - Kiểm tra chuỗi đối xứng sau khi làm sạch
     *
     * Yêu cầu tư duy và phân tích:
     * - Bài toán yêu cầu kiểm tra chuỗi có đối xứng không, bỏ qua ký tự không chữ/số, case insensitive.
     * - Tư duy: Phân biệt chữ cái/số với ký tự đặc biệt, xử lý khoảng trắng, chữ hoa/thường.
     * - Phân tích: Chuỗi có thể dài, có ký tự đặc biệt, rỗng. Cần làm sạch trước khi kiểm tra.
     * - Cách giải quyết vấn đề: Kết hợp regex để làm sạch + two pointers để kiểm tra đối xứng.
     *
     * Giải thuật:
     * - Sử dụng regex [^a-zA-Z0-9] để loại bỏ ký tự không chữ/số, chuyển lowercase.
     * - Two pointers: left từ đầu, right từ cuối, so sánh từng cặp ký tự, di chuyển vào giữa.
     * - Nếu khác nhau → false; duyệt hết → true.
     *
     * Độ phức tạp:
     * - Thời gian: O(n) - làm sạch O(n), kiểm tra O(n/2).
     * - Không gian: O(n) - chuỗi cleaned mới.
     * - Đánh giá: Hiệu quả, regex tiện lợi. Có thể tối ưu không gian bằng cách dùng two pointers trực tiếp trên chuỗi gốc (không tạo cleaned).
     * - Ví dụ: "A man, a plan, a canal: Panama" → cleaned "amanaplanacanalpanama" → true.
     */
    // Regex: loại bỏ ký tự không phải chữ/số, chuyển về lowercase
    // Đảo chuỗi
//    String reversed = new StringBuilder(cleaned).reverse().toString();

    // So sánh
//    boolean isPalindrome = cleaned.equals(reversed);
    private static void validPalindrome(Scanner sc) {
        System.out.println("\n=== Valid Palindrome ===");
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Chuoi rong -> True (coi la palindrome)");
            return;
        }

        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Two pointers: ktra đối xứng
        int left = 0;
        int right = cleaned.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Ket qua: " + (isPalindrome ? "True" : "False"));
        System.out.println("(Sau khi lam sach: " + cleaned + ")");
    }

    /**
     * FR4: Reverse Words - Đảo ngược từ trong câu, loại khoảng trắng thừa
     *
     * Yêu cầu tư duy và phân tích:
     * - Bài toán yêu cầu đảo thứ tự các từ, loại khoảng trắng thừa, giữ một khoảng trắng giữa từ.
     * - Tư duy: Xử lý khoảng trắng đầu/cuối/multiple, chuỗi rỗng/chỉ khoảng trắng.
     * - Phân tích: Câu có thể có ký tự đặc biệt, nhưng giả sử chỉ chữ và khoảng trắng.
     * - Cách giải quyết vấn đề: Tách chuỗi bằng regex, đảo ngược mảng từ, nối lại.
     *
     * Giải thuật:
     * - Trim chuỗi, split bằng \\s+ (một hoặc nhiều khoảng trắng).
     * - Duyệt mảng từ từ cuối về đầu, append vào StringBuilder với khoảng trắng.
     * - Xử lý không có từ → chuỗi rỗng.
     *
     * Độ phức tạp:
     * - Thời gian: O(n) - split O(n), duyệt O(m) với m số từ.
     * - Không gian: O(n) - mảng từ và StringBuilder.
     * - Đánh giá: Đơn giản, hiệu quả. Có thể tối ưu bằng cách reverse toàn chuỗi rồi reverse từng từ (in-place cho StringBuilder).
     * - Ví dụ: "  hello world  " → "world hello".
     */
    // Regex: tách từ bằng một hoặc nhiều khoảng trắng
    // Đảo ngược: duyệt từ cuối mảng
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

    /**
     * FR5: Happy Number - Kiểm tra số hạnh phúc
     *
     * Yêu cầu tư duy và phân tích:
     * - Bài toán: Lặp tính tổng bình phương chữ số đến khi =1 (happy) hoặc vòng lặp (unhappy).
     * - Tư duy: Phát hiện vòng lặp là chìa khóa, vì quá trình luôn hội tụ nhanh (về 1 hoặc vòng 4-...-4).
     * - Phân tích: Số dương, xử lý n=0/âm. Giá trị trung gian nhỏ (<243 cho 3 chữ số).
     * - Cách giải quyết vấn đề: Dùng mảng boolean đánh dấu để phát hiện vòng lặp (dễ hiểu, thay HashSet).
     *
     * Giải thuật:
     * - Khởi tạo mảng boolean[1000] (đủ lớn).
     * - Lặp: Nếu current=1 → happy; nếu seen[current] true → vòng lặp → unhappy.
     * - Đánh dấu seen[current]=true, tính current mới = tổng bình phương chữ số.
     *
     * Độ phức tạp:
     * - Thời gian: O(log n * k) - k là số bước (thường <20), log n cho chữ số.
     * - Không gian: O(1) - mảng kích thước cố định.
     * - Đánh giá: Đơn giản, dễ debug. So với Floyd Cycle (O(1) space, no array), cách này dễ hiểu hơn cho beginner. Vòng lặp luôn ngắn, không lo overflow.
     * - Ví dụ: 19 → 82 → 68 → 100 → 1 (happy); 2 → ... → 4 → loop (unhappy).
     */
    // Mảng boolean đánh dấu các số đã gặp (kích thước 1000 đủ vì max ~243)
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

        // Kiểm tra vòng lặp
        // Đánh dấu
        // Calcu tổng bình phương
        // Check res
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

    // Hàm phụ: Tính tổng bình phương chữ số (ví dụ: 19 → 1^2 + 9^2 = 82)
    // Lấy chữ số cuối
    // Bình phương và cộng
    // Bỏ chữ số cuối
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