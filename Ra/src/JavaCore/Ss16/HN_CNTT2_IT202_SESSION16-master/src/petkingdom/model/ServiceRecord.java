package petkingdom.model;

public class ServiceRecord {
    private Pet pet;
    private String serviceType;

    public ServiceRecord(Pet pet, String serviceType) {
        this.pet = pet;
        this.serviceType = serviceType;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        return "Thú cưng " + pet.getName() + " đang được " + serviceType + ".";
    }
}