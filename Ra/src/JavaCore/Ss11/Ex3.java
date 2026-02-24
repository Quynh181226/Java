package JavaCore.Ss11;

interface IMixable {
    void mix();
}

abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Mã: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Giá gốc: " + price);
    }
}

class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if (hasMilk) {
            return price + 5000;
        } else {
            return price;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if (hasMilk) {
            System.out.println("Có sữa");
        } else {
            System.out.println("Đen đá");
        }
    }
}

class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price - (price * discountPercent / 100.0);
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nước cam", 40000, 10);
        drinks[2] = null;

        System.out.println("=====================================");
        System.out.println("          HÓA ĐƠN ĐỒ UỐNG           ");
        System.out.println("=====================================");

        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.println("\nĐồ uống thứ " + (i + 1) + ":");
                drinks[i].displayInfo();

                System.out.println("Thành tiền: " + drinks[i].calculatePrice() + " VNĐ");

                if (drinks[i] instanceof IMixable) {
                    ((IMixable) drinks[i]).mix();
                }

                System.out.println("-----------------------------");
            }
        }

        System.out.println("=====================================");
    }
}