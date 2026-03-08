package petkingdom.presentation;

import petkingdom.bussiness.impl.*;
import petkingdom.model.*;

import java.util.List;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PetServiceImpl petService = new PetServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        SpaServiceImpl spaService = new SpaServiceImpl();
        HistoryServiceImpl activityLog = new HistoryServiceImpl();

        while (true) {
            System.out.println("\n===== PET KINGDOM =====");
            System.out.println("1. Thêm pet");
            System.out.println("2. Hiện thị danh sách pet");
            System.out.println("3. Đăng ký khách hàng");
            System.out.println("4. Hiện thị danh sách khách hàng");
            System.out.println("5. Thay đổi chủ pet");
            System.out.println("6. Thêm dịch vụ spa");
            System.out.println("7. Quy trình Spa");
            System.out.println("8. Hoàn tác hành động cuối cùng");
            System.out.println("0. Thoát");
            System.out.print("Mời nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addPet(sc, petService, activityLog);
                    break;

                case 2:
                    showAllPet(petService);
                    break;

                case 3:
                    register(sc, customerService, activityLog);
                    break;
                case 4:
                    showAllCustmer(customerService);
                    break;
                case 5:
                    assignOwner(petService, sc, customerService, activityLog);
                    break;
                case 6:
                    petSpa(sc, petService, spaService, activityLog);
                    break;

                case 7:
                    spaService.processNext();
                    break;

                case 8:
                    activityLog.undo();
                    break;

                case 0:
                    return;
            }
        }
    }

    private static void addPet(Scanner sc, PetServiceImpl petServiceImpl, HistoryServiceImpl activityLog) {
        System.out.print("Pet ID: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Loài: ");
        String species = sc.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());
        Pet pet = new Pet(id, name, species, price, null);
        if (petServiceImpl.add(pet) != null) {
            activityLog.push("Thêm pet " + name);
        }
    }

    private static void showAllPet(PetServiceImpl petServiceImpl) {
        List<Pet> pets = petServiceImpl.findAll();
        if (pets.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        System.out.printf("%-5s | %-20s | %-15s | %-12s | %-13s\n", "ID", "Tên", "Loài", "Giá", "ID chủ sở hữu");
        for (Pet e : pets) {
            System.out.printf("%s+%s+%s+%s+%s\n",
                    "-".repeat(6),
                    "-".repeat(22),
                    "-".repeat(17),
                    "-".repeat(14),
                    "-".repeat(14));
            System.out.println(e.toString());
        }
    }

    private static void register(Scanner sc, CustomerServiceImpl customerManager, HistoryServiceImpl activityLog) {
        System.out.print("ID khách hàng: ");
        String cid = sc.nextLine();
        System.out.print("Tên: ");
        String cname = sc.nextLine();
        System.out.print("SDT: ");
        String phone = sc.nextLine();
        if (customerManager.add(new Customer(cid, cname, phone)) != null) {
            activityLog.push("Đăng ký khách hàng " + cname);
        }
    }

    private static void showAllCustmer(CustomerServiceImpl customerService) {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        System.out.printf("%-5s | %-20s | %-15s\n", "ID", "Tên", "SDT");
        for (Customer e : customers) {
            System.out.printf("%s+%s+%s\n",
                    "-".repeat(6),
                    "-".repeat(22),
                    "-".repeat(16));
            System.out.println(e.toString());
        }
    }

    private static void assignOwner(PetServiceImpl petService, Scanner sc, CustomerServiceImpl customerService, HistoryServiceImpl activityLog) {
        showAllPet(petService);
        System.out.print("Mời nhập pet ID: ");
        Pet pet = petService.findById(sc.nextLine());
        if (pet == null) {
            System.out.println("Không tìm thấy pet");
            return;
        }
        showAllCustmer(customerService);
        System.out.print("Mời nhập ID khách hàng: ");
        Customer customer = customerService.findById(sc.nextLine());
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }
        Customer oddOwner = customerService.findById(pet.getOwnerId());
        activityLog.push("cập nhật chủ sở hữu của pet " + pet.getName() + " từ " + (oddOwner == null ? "Vô chủ" : oddOwner.getName()) + " thành " + customer.getName());
        pet.setOwnerId(customer.getId());
    }

    private static void petSpa(Scanner sc, PetServiceImpl petServiceImpl, SpaServiceImpl spaService, HistoryServiceImpl activityLog) {
        System.out.print("Pet ID cho Spa: ");
        String pid = sc.nextLine();
        System.out.print("Dịch vụ: ");
        String service = sc.nextLine();
        Pet p = petServiceImpl.findById(pid);
        if (p != null) {
            spaService.enqueue(new ServiceRecord(p, service));
            activityLog.push("Thêm dịch vụ spa " + service + " cho " + p.getName());
        } else {
            System.out.println("Không tìm thấy pet");
        }
    }
}