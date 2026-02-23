//package JavaCore.Ss11;
//
////[Bài tập thực hành OOP]
////
////Hệ thống Nhân vật Game "Arena of Heroes"
////1. Mục tiêu
////Kết hợp Abstract Class để định nghĩa khung nhân vật cơ bản.
////Sử dụng Interface để định nghĩa hành vi (kỹ năng đặc biệt).
////Áp dụng Polymorphism để quản lý danh sách nhân vật.
////Sử dụng Anonymous Class để tạo đối tượng đặc biệt (Boss/Quái vật) mà không cần tạo file class riêng.
////Vận dụng Static để đếm số lượng nhân vật.
////2. Mô tả bài toán
////A. Thiết kế Abstract Class & Interface
////Interface ISkill:
////Chứa phương thức trừu tượng: void useUltimate(GameCharacter target) (Sử dụng chiêu cuối lên mục tiêu).
////Abstract Class GameCharacter:
////Thuộc tính:
////name (String): Tên nhân vật.
////hp (int): Máu hiện tại.
////attackPower (int): Sức tấn công cơ bản.
////static int count: Biến tĩnh đếm số lượng nhân vật đã tạo.
////Constructor: Khởi tạo thông tin và tăng biến count.
////Phương thức:
////getter/setter cần thiết.
////void attack(GameCharacter target): Phương thức trừu tượng (mỗi loại nhân vật đánh 1 kiểu).
////void takeDamage(int amount): Giảm HP khi bị đánh. Nếu HP <= 0 thì in ra "Đã bị hạ gục".
////void displayInfo(): In thông tin cơ bản.
////B. Thiết kế các Lớp con (Concrete Classes)
////Class Warrior (Chiến binh) - Kế thừa GameCharacter, thực thi ISkill:
////Thuộc tính riêng: armor (giáp - giảm sát thương nhận vào).
////Override attack(): Gây sát thương vật lý (= attackPower).
////Override useUltimate(): Kỹ năng "Đấm ngàn cân" - Gây sát thương gấp đôi attackPower nhưng tự mất 10% HP hiện tại do gắng sức.
////Override takeDamage(): Trừ giáp vào sát thương nhận vào trước khi trừ máu.
////Class Mage (Pháp sư) - Kế thừa GameCharacter, thực thi ISkill:
////Thuộc tính riêng: mana (năng lượng).
////Override attack(): Gây sát thương phép (= attackPower). Mỗi lần đánh tốn 5 mana. Nếu hết mana thì đánh thường (sát thương giảm 1 nửa).
////Override useUltimate(): Kỹ năng "Hỏa cầu" - Tốn 50 mana để gây lượng sát thương khủng khiếp.
////C. Chương trình chính (Main Class)
////Tạo danh sách chứa các GameCharacter.
////Thêm vào danh sách: 1 Warrior, 1 Mage.
////Yêu cầu Anonymous Class:
////Tạo thêm một đối tượng GameCharacter đại diện cho "Goblin (Quái vật)" trực tiếp bằng Anonymous Class ngay trong hàm main (không tạo file class riêng).
////Goblin này có cách tấn công (attack) là: In ra "Goblin cắn trộm..." và gây sát thương cố định là 10.
////Giả lập trận đấu (Loop):
////Cho tất cả nhân vật trong danh sách lần lượt tấn công lẫn nhau (hoặc tấn công 1 mục tiêu chỉ định).
////Gọi thử useUltimate() của Warrior và Mage.
////In ra tổng số nhân vật đã được tạo (dùng biến static count).
////3. Kết quả mong muốn (Sample Output)
////Plaintext
////=== ARENA OF HEROES ===
////Đã khởi tạo 3 nhân vật tham gia đấu trường.
////1. [Chiến binh] Yasuo tấn công Goblin!
////-> Goblin mất 50 máu. HP còn: 50.
////
////2. [Pháp sư] Veigar dùng chiêu cuối lên Yasuo!
////-> Veigar tốn 50 mana. Yasuo mất 100 máu.
////
////3. [Quái vật] Goblin (Anonymous Class) tấn công!
////-> Goblin cắn trộm Veigar... Gây 10 sát thương.
////
////=== THÔNG SỐ SAU LƯỢT ĐẤU ===
////Tên: Yasuo | HP: 400 | Giáp: 20
////Tên: Veigar | HP: 290 | Mana: 150
////Tên: Goblin | HP: 50
////
////4. Tiêu chí đánh giá & Gợi ý code
////Kiến thức: Phân biệt được khi nào dùng implements ISkill (cho hành động đặc biệt) và extends GameCharacter (cho bản chất).
////Anonymous Class: Viết đúng cú pháp:
////Java
////GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
////    @Override
////    public void attack(GameCharacter target) {
////        System.out.println("Goblin cắn trộm...");
////        target.takeDamage(10);
////    }
////};
////Logic: Xử lý đúng phần trừ giáp của Warrior và trừ mana của Mage.
//public class Btth {
//}
package JavaCore.Ss11;

import java.util.ArrayList;
import java.util.List;

public class Btth {

    // Interface định nghĩa kỹ năng đặc biệt
    interface ISkill {
        void useUltimate(GameCharacter target);
    }

    // Abstract class khung nhân vật
    abstract static class GameCharacter {
        protected String name;
        protected int hp;
        protected int attackPower;
        protected static int count = 0;

        public GameCharacter(String name, int hp, int attackPower) {
            this.name = name;
            this.hp = hp;
            this.attackPower = attackPower;
            count++;
        }

        public String getName() { return name; }
        public int getHp() { return hp; }

        // Tấn công cơ bản (trừu tượng)
        public abstract void attack(GameCharacter target);

        // Nhận sát thương
        public void takeDamage(int amount) {
            if (hp <= 0) return;
            hp -= amount;
            if (hp <= 0) {
                hp = 0;
                System.out.println(name + " đã bị hạ gục!");
            }
        }

        // In thông tin
        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp);
        }
    }

    // Chiến binh
    static class Warrior extends GameCharacter implements ISkill {
        private int armor;

        public Warrior(String name, int hp, int attackPower, int armor) {
            super(name, hp, attackPower);
            this.armor = armor;
        }

        @Override
        public void attack(GameCharacter target) {
            System.out.println("[" + name + "] tấn công " + target.getName() + "!");
            target.takeDamage(attackPower);
            System.out.println("-> " + target.getName() + " mất " + attackPower + " máu. HP còn: " + target.getHp() + "\n");
        }

        @Override
        public void useUltimate(GameCharacter target) {
            int damage = attackPower * 2;
            System.out.println("[" + name + "] dùng chiêu cuối 'Đấm ngàn cân' lên " + target.getName() + "!");
            target.takeDamage(damage);
            int selfDamage = (int) (hp * 0.1);
            takeDamage(selfDamage);
            System.out.println("-> Gây " + damage + " sát thương, tự mất " + selfDamage + " HP do gắng sức.\n");
        }

        @Override
        public void takeDamage(int amount) {
            int realDamage = Math.max(0, amount - armor);
            super.takeDamage(realDamage);
            if (realDamage > 0) {
                System.out.println("-> " + name + " mất " + realDamage + " máu (giáp chặn " + armor + "). HP còn: " + hp + "\n");
            } else {
                System.out.println("-> Giáp chặn hết sát thương!\n");
            }
        }

        @Override
        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
        }
    }

    // Pháp sư
    static class Mage extends GameCharacter implements ISkill {
        private int mana;

        public Mage(String name, int hp, int attackPower, int mana) {
            super(name, hp, attackPower);
            this.mana = mana;
        }

        @Override
        public void attack(GameCharacter target) {
            System.out.println("[" + name + "] tấn công " + target.getName() + "!");
            int damage;
            if (mana >= 5) {
                mana -= 5;
                damage = attackPower;
                System.out.println("(Tốn 5 mana)");
            } else {
                damage = attackPower / 2;
                System.out.println("(Hết mana, sát thương giảm nửa)");
            }
            target.takeDamage(damage);
            System.out.println("-> " + target.getName() + " mất " + damage + " máu. HP còn: " + target.getHp() + "\n");
        }

        @Override
        public void useUltimate(GameCharacter target) {
            if (mana >= 50) {
                mana -= 50;
                int damage = 100; // sát thương khủng
                System.out.println("[" + name + "] dùng chiêu cuối 'Hỏa cầu' lên " + target.getName() + "!");
                System.out.println("(Tốn 50 mana)");
                target.takeDamage(damage);
                System.out.println("-> Gây " + damage + " sát thương khủng khiếp!\n");
            } else {
                System.out.println("[" + name + "] không đủ mana để dùng chiêu cuối!\n");
            }
        }

        @Override
        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ARENA OF HEROES ===\n");

        List<GameCharacter> arena = new ArrayList<>();

        // Thêm nhân vật
        Warrior yasuo = new Warrior("Yasuo", 500, 50, 20);
        Mage veigar = new Mage("Veigar", 300, 40, 200);
        arena.add(yasuo);
        arena.add(veigar);

        // Anonymous Class cho Goblin (Quái vật)
        GameCharacter goblin = new GameCharacter("Goblin", 100, 0) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin (Anonymous Class) tấn công!");
                System.out.println("Goblin cắn trộm " + target.getName() + "...");
                target.takeDamage(10);
                System.out.println("-> Gây 10 sát thương. HP còn: " + target.getHp() + "\n");
            }

            @Override
            public void displayInfo() {
                System.out.println("Tên: " + name + " | HP: " + hp);
            }
        };
        arena.add(goblin);

        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        // Giả lập lượt đấu đơn giản
        System.out.println("1. " + yasuo.getName() + " tấn công " + goblin.getName() + "!");
        yasuo.attack(goblin);

        System.out.println("2. " + veigar.getName() + " dùng chiêu cuối lên " + yasuo.getName() + "!");
        veigar.useUltimate(yasuo);

        System.out.println("3. " + goblin.getName() + " tấn công!");
        goblin.attack(veigar);

        // In thông số sau lượt đấu
        System.out.println("=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter c : arena) {
            c.displayInfo();
        }
    }
}