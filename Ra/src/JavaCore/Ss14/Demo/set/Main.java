package JavaCore.Ss14.Demo.set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Set kế thừa Collection
        //Set ko lưu trữ phtu trùng lặp

        //4 lớp triển khai
        //HashSet( Ko xđ thứ tự lưu )
        //LinkedHashSet( Vtri chen )
        //TReeSet (Cây nhị phân, đc sắp xếp)
        //EnumSet ( Nhẹ và nhanh, chỉ nhanh khi tìm kiếm, và nó là hẳng nên ko thay đổi đc )

//        Set<Integer> set = new HashSet<>();
//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        Set<Sex> set=EnumSet.of(Sex.Male, Sex.Female, Sex.Other);
//        set.add(1);
//        set.add(10);
//        set.add(20);
//        set.add(30);
//        set.add(40);
        System.out.println(set);

        //Các phương thức làm việc
        //Dùng cho các bài toán tìm kiếm, ít sử dụng, bài toán đặc trưng
        //Hai gtri giống nhau thì ko đc ghi
        TreeSet<Integer> set1=new TreeSet<>();
        set1.add(1);
        //Ko đc lưu
        set1.add(2);

        // Duyệt Set
        for(Integer val:set1){

        }

        //Duyệt = interator
//        Interator<Integer> integrator=new Interator<Integer>();

    }
}
