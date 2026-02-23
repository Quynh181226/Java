package JavaCore.Ss11;
/**
 * LỚP MAGE - PHÁP SƯ
 * * 1. YÊU CẦU TƯ DUY PHÂN TÍCH:
 * - Yêu cầu: Nhân vật dùng Mana để đánh phép, nếu hết Mana thì yếu đi.
 * - Tư duy: Sử dụng cấu trúc điều kiện để kiểm tra tài nguyên Mana.
 */
public class Mage extends GameCharacter implements ISkill {
    // Mana: tài nguyên phép, dùng cho đòn đánh và chiêu cuối (giảm dần khi sử dụng kỹ năng)
    private int mana;

    /**
     * CONSTRUCTOR MAGE - KHỞI TẠO PHÁP SƯ
     * 1. GIẢI THUẬT:
     * Bước 1: Gọi constructor lớp cha GameCharacter để khởi tạo name, hp, attackPower chung.
     * Bước 2: Gán thêm thuộc tính mana là tài nguyên riêng cho pháp sư.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    /**
     * TẤN CÔNG THƯỜNG (KIỂM TRA MANA)
     * 1. GIẢI THUẬT:
     * Bước 1: Nếu mana >= 5: Gây full dame và trừ 5 mana.
     * Bước 2: Nếu mana < 5: Gây dame chia 2 và không trừ mana.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    @Override
    public void attack(GameCharacter target) {
        if (mana >= 5) {
            System.out.println("[Pháp sư] " + name + " bắn tia sáng phép thuật vào " + target.getName() + "!");
            target.takeDamage(this.attackPower);
            this.mana -= 5;
        } else {
            System.out.println("[Pháp sư] " + name + " cạn năng lượng, đánh thường yếu ớt...");
            target.takeDamage(this.attackPower / 2);
        }
    }

    /**
     * CHIÊU CUỐI: HỎA CẦU
     * 1. GIẢI THUẬT:
     * Bước 1: Kiểm tra mana >= 50.
     * Bước 2: Nếu đủ, gây dame * 3 và trừ 50 mana. Nếu không, thông báo thất bại.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    @Override
    public void useUltimate(GameCharacter target) {
        if (mana >= 50) {
            System.out.println("[Pháp sư] " + name + " niệm chú 'Hỏa cầu' cực đại lên " + target.getName() + "!");
            this.mana -= 50;
            target.takeDamage(this.attackPower * 3);
        } else {
            System.out.println("   -> Không đủ 50 mana để dùng chiêu cuối!");
        }
    }

    /**
     * HIỂN THỊ THÔNG TIN PHÁP SƯ
     * 1. GIẢI THUẬT:
     * Bước 1: Lấy các thuộc tính name, hp, mana hiện tại của đối tượng.
     * Bước 2: Ghép thành chuỗi mô tả và in ra màn hình.
     * 2. ĐỘ PHỨC TẠP: O(1)
     * - Thể hiện tính đa hình: override phương thức displayInfo của lớp cha để hiển thị thêm Mana.
     */
    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}