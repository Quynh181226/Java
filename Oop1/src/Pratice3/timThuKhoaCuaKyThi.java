package Pratice3;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    //static để tăng tự động
    private static int num=1;
    private int id;
    private String name, dob;
    private Float p1, p2, p3, total;
    public Student(String name, String dob, Float p1, Float p2, Float p3) {
        this.id=num++;
        this.name=name;
        this.dob=dob;
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.total=p1+p2+p3;
    }
    public Float getTotal() {
        return total;
    }
    @Override
    public int compareTo(Student o) {
//        if(this.total.compareTo(o.total)==0){
//            return (this.id-o.id);
//        }
//        return -(this.total.compareTo(o.total));
        if(Float.compare(o.total, this.total)==0){
            return Integer.compare(this.id, o.id);
        }
        return Float.compare(o.total, this.total);
    }
    @Override
    public String toString() {
        return id+" "+name+" "+dob+" "+String.format("%.1f", total);
    }
}
public class timThuKhoaCuaKyThi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        Student[] stu=new Student[n];
        for(int i=0;i<n;i++) {
            String name=sc.nextLine();
            String dob=sc.nextLine();
            float p1=Float.parseFloat(sc.nextLine());
            float p2=Float.parseFloat(sc.nextLine());
            float p3=Float.parseFloat(sc.nextLine());
            stu[i]=new Student(name,dob,p1,p2,p3);
        }
        Arrays.sort(stu);
        float highest=stu[0].getTotal();
        for (Student s: stu) {
            if(s.getTotal().equals(highest)){
                System.out.println(s);
            }else{
                break;
            }
        }
    }
}
