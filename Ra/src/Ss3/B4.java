package Ss3;

public class B4 {
    public static void main(String[] args) {
        int[] bookIds = {5, 1, 4, 2, 8};

        sortBooks(bookIds);
    }

    public static void sortBooks(int[] arr){
        System.out.println("Trước khi sắp xếp: ");
        for (int i = 0 ; i < arr.length ; i ++){
            System.out.printf("%d ", arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("\nSau khi sắp xếp: ");
        for (int i = 0 ; i < arr.length ; i ++){
            System.out.printf("%d ", arr[i]);
        }
    }
}