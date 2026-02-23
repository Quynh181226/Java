package JavaCore.Ss11;
/**
 * LỚP TRỪU TƯỢNG GAMECHARACTER - KHUNG XƯƠNG CỦA MỌI NHÂN VẬT
 * * 1. YÊU CẦU TƯ DUY PHÂN TÍCH:
 * - Yêu cầu: Quản lý thuộc tính chung (Tên, Máu, Sức mạnh) và biến đếm hệ thống.
 * - Tư duy: Áp dụng Abstraction để làm lớp cha, ngăn chặn việc tạo đối tượng chung chung.
 * - Triển khai: Sử dụng từ khóa abstract và biến static.
 */
public abstract class GameCharacter {
    // ===== CÁC THUỘC TÍNH (ATTRIBUTES) =====
    protected String name;      // Tên nhân vật
    protected int hp;           // Máu hiện tại
    protected int attackPower;  // Sức tấn công cơ bản

    /**
     * BIẾN TĨNH ĐẾM SỐ NHÂN VẬT (count)
     * 1. MỤC ĐÍCH:
     * - Theo dõi tổng số đối tượng GameCharacter (và các lớp con) đã được tạo trong hệ thống.
     * 2. CƠ CHẾ HOẠT ĐỘNG:
     * - Mỗi lần constructor GameCharacter được gọi, biến này sẽ tự động tăng lên 1.
     * 3. TƯ DUY OOP:
     * - Ví dụ điển hình cho thuộc tính dùng chung cho mọi đối tượng (thuộc về lớp - class level),
     *   chứ không thuộc về từng đối tượng riêng lẻ (instance level).
     */
    public static int count = 0; // Biến tĩnh đếm tổng số nhân vật toàn hệ thống

    /**
     * CONSTRUCTOR - KHỞI TẠO NHÂN VẬT
     * 1. CÁC BƯỚC GIẢI THUẬT:
     * Bước 1: Gán giá trị tham số vào biến instance thông qua từ khóa this.
     * Bước 2: Tăng biến tĩnh count lên 1 (mỗi khi có 1 nhân vật mới sinh ra).
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    // GETTER: Truy cập thông tin an toàn (ẩn giấu dữ liệu - Encapsulation)
    public String getName() { return name; }
    public int getHp() { return hp; }

    /**
     * PHƯƠNG THỨC TẤN CÔNG (ABSTRACT)
     * - Tư duy: Mỗi nhân vật có cách tấn công khác nhau nên lớp cha không cài đặt cụ thể.
     */
    public abstract void attack(GameCharacter target);

    /**
     * LOGIC NHẬN SÁT THƯƠNG (TAKEDAMAGE)
     * 1. CÁC BƯỚC GIẢI THUẬT:
     * Bước 1: HP mới = HP cũ - sát thương nhận vào (amount).
     * Bước 2: Nếu HP < 0, gán HP = 0 để tránh lỗi logic chỉ số âm.
     * Bước 3: In ra lượng máu mất và kiểm tra trạng thái hạ gục.
     * 2. ĐỘ PHỨC TẠP: O(1)
     */
    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
        System.out.println("   -> " + name + " mất " + amount + " máu. HP còn: " + hp);
        if (this.hp <= 0) {
            System.out.println("   [!] " + name + " đã bị hạ gục!");
        }
    }

    /**
     * HIỂN THỊ THÔNG TIN CƠ BẢN
     * 1. GIẢI THUẬT:
     * Bước 1: Gộp các thuộc tính cơ bản (tên, HP) thành một chuỗi duy nhất.
     * Bước 2: In chuỗi này ra màn hình console để quan sát trạng thái nhân vật.
     * 2. ĐỘ PHỨC TẠP: O(1)
     * - Lưu ý: Phương thức này được thiết kế để các lớp con có thể override, bổ sung
     *   thêm thuộc tính riêng (ví dụ: Mana, Giáp, ...) nhưng vẫn tái sử dụng được concept chung.
     */
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }
}