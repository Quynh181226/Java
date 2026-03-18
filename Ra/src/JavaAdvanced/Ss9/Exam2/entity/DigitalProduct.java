package JavaAdvanced.Ss9.Exam2.entity;

public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct() {
    }

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

//    public void setSize(double size) {
//        this.size = size;
//    }

    @Override
    public void displayInfo() {
        System.out.println("===== DIGITAL PRODUCT =====");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Size: " + getSize() + " Mb");
        System.out.println("============================");
    }
}