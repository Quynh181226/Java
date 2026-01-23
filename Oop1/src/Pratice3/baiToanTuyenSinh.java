package Pratice3;
import java.util.*;

class Student1 {
    private String ID, Name, Status;
    private double pMath, pPhysics, pChemistry, pTotal, pPriority;

    public Student1(String ID, String name, double pMath, double pPhysics, double pChemistry) {
        this.ID = ID;
        this.Name = name;
        this.pMath = pMath;
        this.pPhysics = pPhysics;
        this.pChemistry = pChemistry;

        // Ưu tiên theo ký tự thứ 3 của ID
        if (this.ID.charAt(2) == '1')
            this.pPriority = 0.5;
        else if (this.ID.charAt(2) == '2')
            this.pPriority = 1;
        else if(this.ID.charAt(2) == '3')
            this.pPriority = 2.5;
        else
            this.pPriority = 0;
        // Tổng điểm (Toán nhân đôi)
        this.pTotal = this.pChemistry + this.pMath * 2 + this.pPhysics;

        // Trạng thái trúng tuyển
        if (this.pTotal + this.pPriority >= 24)
            this.Status = "TRUNG TUYEN";
        else
            this.Status = "TRUOT";
    }

    @Override
    public String toString() {
        String res = String.format("%s %s ", this.ID, this.Name);
        if (this.pPriority == (int) this.pPriority)
            res += String.format("%.0f ", this.pPriority);
        else
            res += String.format("%.1f ", this.pPriority);

        if (this.pTotal == (int) this.pTotal)
            res += String.format("%.0f ", this.pTotal);
        else
            res += String.format("%.1f ", this.pTotal);

        res += this.Status;
        return res;
    }
}

// Tách class main ra ngoài
class baiToanTuyenSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student1 A = new Student1(
                sc.nextLine(),
                sc.nextLine(),
                Double.parseDouble(sc.nextLine()),
                Double.parseDouble(sc.nextLine()),
                Double.parseDouble(sc.nextLine())
        );
        System.out.println(A);
    }
}
