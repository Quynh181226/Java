package JavaCore.Ss16;

public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths > 12) {
            return getPrice() + 1_000_000;
        }
        return getPrice();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Bảo hành: %d tháng | Thành tiền: %.0f%n",
                warrantyMonths, calculateFinalPrice());
    }
}
