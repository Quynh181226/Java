package JavaCore.Ss11;

public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

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

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}