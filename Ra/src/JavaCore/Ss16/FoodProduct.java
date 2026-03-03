package JavaCore.Ss16;

public class FoodProduct extends Product {
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountPercent / 100.0);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Giảm: %d%% | Thành tiền: %.0f%n ",
                discountPercent, calculateFinalPrice());
    }
}
