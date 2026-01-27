package Ss3;

import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        String[] names = {"Abc", "Abd", "Abg", "Abj", "Abl"};
        int[] quantities = {1, 2, 3, 4, 5};

        maxQuantityOfBooks(names, quantities);
        minQuantityOfBooks(names, quantities);
    }

    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        int max = quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.println("Sách có số lượng nhiều nhất (" + max + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i]);
            }
        }
        System.out.println("------------------");
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        int min = quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.println("Sách có số lượng ít nhất (" + min + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i]);
            }
        }
        System.out.println("------------------");
    }
}