package JavaAdvanced.Ss11.Ex5.entity;

public class Doctor {
    private int id;
    private String name;
    private String speciality;
    public Doctor(){

    }
    public Doctor(int id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality=speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", speciality=" + speciality + "]";
    }
}
