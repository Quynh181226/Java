package JavaCore.Ss14.Demo.Pratice;

import java.util.*;

public class Ex {
    public  static void main(String[] args) {
//        //Bài tập:
//        //1. Tạo 1 List ngẩu nhiên 100 số t 0-1000
//        Random rad=new Random();
////        rad.nextInt(1000);
//
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<100;i++){
//            list.add(rad.nextInt(50));
//        }
//
//        System.out.println(list);
//        //1.1: Loại bỏ phtu trùng lặp trg d/sach
//        Set<Integer> set=new HashSet<Integer>();
//        //1.2: Đếm số lần xuất hiện của các phtu
//        for(Map.Entry<Integer, Integer> entry: map.entrySet)
//        //1.3: Sắp xếp


        Random rad = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(rad.nextInt(50));
        }
        System.out.println(list);
        Set<Integer> set = new HashSet<>(list);
        // đếm số phần tử
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num: list){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet() ){
            System.out.println();
        }
    }
}
