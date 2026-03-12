
package JavaAdvanced.Ss5.Exam1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager manager = new ProductManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            System.out.println("=============================================");
            System.out.print("Lựa chọn của bạn: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addNewProduct();
                        break;
                    case 2:
                        manager.displayProducts();
                        break;
                    case 3:
                        updateProductQuantity();
                        break;
                    case 4:
                        manager.removeStock();
                        break;
                    case 5:
                        System.out.println("\nExit program");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            } catch (InvalidProductException e) {
                System.out.println("Err: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Err: So nguyen ko hop le");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Err: " + e.getMessage());
            }

            scanner.nextLine();
        }
    }

    private static void addNewProduct() {
        System.out.print("Nhap id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhap ten: ");
        String name = scanner.nextLine().trim();

        System.out.print("Nhap gia: ");
        double price = scanner.nextDouble();

        System.out.print("Nhap slg: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhap cate: ");
        String category = scanner.nextLine().trim();

        Product product = new Product(id, name, price, quantity, category);
        manager.addProduct(product);
    }

    private static void updateProductQuantity() {
        System.out.print("Nhap id: ");
        int id = scanner.nextInt();

        System.out.print("Nhap slg: ");
        int newQuantity = scanner.nextInt();

        manager.updateQuantity(id, newQuantity);
    }
}
