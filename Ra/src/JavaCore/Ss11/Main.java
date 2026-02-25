package JavaCore.Ss11;

public class Main {
    public static void main(String[] args) {
        GameCharacter[] characters = new GameCharacter[3];

        characters[0] = new Warrior("Yasuo", 450, 50, 15);
        characters[1] = new Mage("Veigar", 300, 70, 150);

        characters[2] = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin cắn trộm " + target.getName() + "!");
                target.takeDamage(10);
            }
        };

        System.out.println("=== ARENA OF HEROES ===");
        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");


        System.out.print("1. ");
        characters[0].attack(characters[2]);

        System.out.print("\n2. ");
        if (characters[1] instanceof ISkill) {
            ((ISkill) characters[1]).useUltimate(characters[0]);
        }

        System.out.print("\n3. ");
        characters[2].attack(characters[1]);

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter c : characters) {
            if (c != null) {
                c.displayInfo();
            }
        }
    }
}