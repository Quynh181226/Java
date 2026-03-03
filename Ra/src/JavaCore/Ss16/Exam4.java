package JavaCore.Ss16;

import java.util.*;

public class Exam4 {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("E001", "Tivi", 18000000, 24));
        repo.add(new ElectronicProduct("E002", "Máy lạnh", 9500000, 12));
        repo.add(new FoodProduct("F001", "Sữa tươi", 35000, 15));
        repo.add(new FoodProduct("F002", "Bánh cake", 280000, 20));

        System.out.println("1.D/sach sph");
        List<Product> allProducts = repo.findAll();
        if (allProducts.isEmpty()) {
            System.out.println("D/sach rong");
        } else {
            for (Product p : allProducts) {
                p.displayInfo();
            }
        }

        System.out.println("2. Tim sph theo id");
        Product found = repo.findById("E001");
        if (found != null) {
            System.out.println("+-----------------------------------------------------------------------------------+");
            found.displayInfo();
            System.out.println("+-----------------------------------------------------------------------------------+");
        } else {
            System.out.println("Ko tim thay sph");
        }

        System.out.println("3. Sap xep d/sach theo gia tang dan\n");
        List<Product> sorted = repo.getSortedByPrice();
        for (Product p : sorted) {
            p.displayInfo();
        }

        System.out.println("4. Thong ke slg sph theo tung loai");
        Map<String, Integer> stats = repo.getTypeStatistics();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " sp");
        }
    }
}