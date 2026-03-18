package JavaAdvanced.Ss9.Exam2.entity;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

//    public void setWeight(double weight) {
//        this.weight = weight;
//    }

    @Override
    public void displayInfo() {
        System.out.println("===== PHYSICAL PRODUCT =====");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("=============================");
    }
}