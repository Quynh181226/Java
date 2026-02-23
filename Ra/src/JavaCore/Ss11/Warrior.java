package JavaCore.Ss11;
/**
 * LỚP WARRIOR - CHIẾN BINH
 * * 1. YÊU CẦU TƯ DUY PHÂN TÍCH:
 * - Yêu cầu: Tạo nhân vật có giáp giảm sát thương và kỹ năng tốn máu bản thân.
 * - Tư duy: Kế thừa GameCharacter và thực thi ISkill.
 * - Triển khai: Override takeDamage để trừ giáp và useUltimate cho sát thương vật lý.
 */
public class Warrior extends GameCharacter implements ISkill {
    // Giáp: chỉ số giúp giảm bớt sát thương thực tế nhận vào
    private int armor; // Giáp giúp giảm sát thương nhận vào

    /**
     * CONSTRUCTOR WARRIOR - KHỞI TẠO CHIẾN BINH
     * 1. GIẢI THUẬT:
     * Bước 1: Gọi constructor lớp cha GameCharacter để thiết lập name, hp, attackPower.
     * Bước 2: Gán thêm chỉ số armor cho riêng chiến binh.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    /**
     * LOGIC NHẬN SÁT THƯƠNG CÓ GIÁP
     * 1. GIẢI THUẬT:
     * Bước 1: Sát thương thực tế = amount - armor.
     * Bước 2: Nếu thực tế < 0, coi như bằng 0.
     * Bước 3: Gọi hàm super.takeDamage để thực thi logic trừ máu của lớp cha.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    @Override
    public void takeDamage(int amount) {
        int realDamage = Math.max(0, amount - armor);
        super.takeDamage(realDamage);
    }

    /**
     * TẤN CÔNG THƯỜNG CỦA CHIẾN BINH
     * 1. GIẢI THUẬT:
     * Bước 1: In ra mô tả hành động tấn công và tên mục tiêu.
     * Bước 2: Gọi target.takeDamage với lượng sát thương vật lý bằng attackPower.
     * 2. ĐỘ PHỨC TẠP: O(1)
     * - Lưu ý: Logic giảm sát thương khi mục tiêu là Warrior sẽ được xử lý ở phương thức
     *   takeDamage đã override, không cần xử lý tại đây.
     */
    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " tung đòn tấn công vật lý vào " + target.getName() + "!");
        target.takeDamage(this.attackPower);
    }

    /**
     * CHIÊU CUỐI: ĐẤM NGÀN CÂN
     * 1. GIẢI THUẬT:
     * Bước 1: Gây sát thương = attackPower * 2 lên mục tiêu.
     * Bước 2: Bản thân tự mất 10% HP hiện tại (tác dụng phụ).
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng chiêu 'Đấm ngàn cân'!");
        target.takeDamage(this.attackPower * 2);
        int selfDamage = (int)(this.hp * 0.1);
        this.hp -= selfDamage;
        System.out.println("   -> " + name + " gắng sức và tự mất " + selfDamage + " HP.");
    }

    /**
     * HIỂN THỊ THÔNG TIN CHIẾN BINH
     * 1. GIẢI THUẬT:
     * Bước 1: Lấy các thuộc tính name, hp, armor hiện tại.
     * Bước 2: In ra màn hình để quan sát khả năng chống chịu của nhân vật.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}