/**
 * LỚP MAIN - ĐIỀU KHIỂN GIẢ LẬP TRẬN ĐẤU
 * * 1. YÊU CẦU TƯ DUY PHÂN TÍCH:
 * - Yêu cầu: Khởi tạo mảng đa hình, sử dụng Anonymous Class và chạy kịch bản trận đấu.
 * - Tư duy: Quản lý danh sách đối tượng thông qua lớp cha GameCharacter.
 */
package JavaCore.Ss11;
public class Main {
    /**
     * HÀM main - ĐIỂM VÀO CHƯƠNG TRÌNH
     * 1. GIẢI THUẬT TỔNG QUÁT:
     * Bước 1: Khởi tạo mảng đa hình GameCharacter[] với các loại nhân vật khác nhau
     *         (Warrior, Mage, anonymous class Goblin).
     * Bước 2: In ra số lượng nhân vật đã được tạo dựa trên biến tĩnh GameCharacter.count.
     * Bước 3: Chạy kịch bản mô phỏng 3 lượt tấn công lần lượt giữa các nhân vật.
     * Bước 4: Duyệt qua mảng và gọi displayInfo() để thống kê chỉ số cuối cùng của từng nhân vật.
     * 2. ĐỘ PHỨC TẠP:
     * - Phần khởi tạo và kịch bản: O(1) (số bước cố định).
     * - Vòng lặp thống kê cuối: O(n) với n là số nhân vật trong mảng.
     */
    public static void main(String[] args) {
        // Khởi tạo mảng chứa các nhân vật (Đa hình)
        // Độ phức tạp: O(1)
        GameCharacter[] characters = new GameCharacter[3];

        characters[0] = new Warrior("Yasuo", 450, 50, 15);
        characters[1] = new Mage("Veigar", 300, 70, 150);

        /**
         * ANONYMOUS CLASS - QUÁI VẬT GOBLIN
         * 1. GIẢI THUẬT: Định nghĩa trực tiếp lớp quái vật mà không tạo file .java riêng.
         * 2. PHÂN TÍCH: Gây sát thương cố định là 10.
         */
        characters[2] = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin cắn trộm " + target.getName() + "!");
                target.takeDamage(10);
            }
        };

        System.out.println("=== ARENA OF HEROES ===");
        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        // --- KỊCH BẢN MÔ PHỎNG ---
        // 1. Yasuo tấn công Goblin
        System.out.print("1. ");
        characters[0].attack(characters[2]);

        // 2. Veigar dùng chiêu cuối lên Yasuo
        System.out.print("\n2. ");
        if (characters[1] instanceof ISkill) {
            ((ISkill) characters[1]).useUltimate(characters[0]);
        }

        // 3. Goblin tấn công Veigar
        System.out.print("\n3. ");
        characters[2].attack(characters[1]);

        // --- THỐNG KÊ CUỐI CÙNG (O(n)) ---
        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter c : characters) {
            if (c != null) {
                c.displayInfo(); // Tính đa hình: Tự động gọi đúng phương thức của từng con
            }
        }
    }
}