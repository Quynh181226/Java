package JavaCore.Ss11;

public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;

    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
        System.out.println("   -> " + name + " mất " + amount + " máu. HP còn: " + hp);
        if (this.hp <= 0) {
            System.out.println("   [!] " + name + " đã bị hạ gục!");
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }
}