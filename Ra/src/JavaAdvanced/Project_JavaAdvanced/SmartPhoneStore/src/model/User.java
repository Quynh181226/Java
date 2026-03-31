package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;
    private boolean isActive;

    public User() {}

    public User(String fullName, String email, String password, String phone, String address) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = "Customer";
        this.isActive = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", role='" + role + '\'' +
//                ", isActive=" + isActive +
//                '}';
//    }
}