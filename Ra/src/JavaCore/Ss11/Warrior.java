package JavaCore.Ss11;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void takeDamage(int amount) {
        int realDamage = Math.max(0, amount - armor);
        super.takeDamage(realDamage);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " tung đòn tấn công vật lý vào " + target.getName() + "!");
        target.takeDamage(this.attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng chiêu 'Đấm ngàn cân'!");
        target.takeDamage(this.attackPower * 2);
        int selfDamage = (int)(this.hp * 0.1);
        this.hp -= selfDamage;
        System.out.println("   -> " + name + " gắng sức và tự mất " + selfDamage + " HP.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}