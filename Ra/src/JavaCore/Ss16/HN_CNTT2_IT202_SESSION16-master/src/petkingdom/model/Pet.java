package petkingdom.model;

public class Pet {
    private String id;
    private String name;
    private String species;
    private double price;
    private String ownerId; // liên kết Customer

    public Pet(String id, String name, String species, double price, String ownerId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.price = price;
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getPrice() {
        return price;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-20s | %-15s | %-10.2f $ | %-13s", id, name, species, price, ownerId == null ? "Vô chủ" : ownerId);
    }
}