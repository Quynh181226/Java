package JavaCore.Ss3;

public class B5 {
    public static void main(String[] args) {
        int[] inventory = new int[10];
        inventory[0] = 101; inventory[1] = 102; inventory[2] = 103;
        inventory[3] = 104; inventory[4] = 105;
        int currCnt = 5;

        currCnt = deleteBook(inventory, currCnt, 103);
    }

    public static int deleteBook(int[] arr, int n, int bookId){
        int index = -1;
        for (int i = 0 ; i < n ; i ++){
            if(arr[i] == bookId){
                index = i;
                break;
            }
        }

        if(index == -1) {
            System.out.println("Không tìm thấy sách với mã " + bookId);
            return n;
        }

        for (int i = index ; i < n - 1 ; i ++){
            arr[i] = arr[i+1];
        }

        n--;

        System.out.println("\nĐã xóa mã sách " + bookId);
        System.out.printf("Kho sách hiện tại: %d cuốn\n", n);
        for (int i = 0 ; i < n ; i ++){
            System.out.printf("%d ", arr[i]);
        }
        return n;
    }
}