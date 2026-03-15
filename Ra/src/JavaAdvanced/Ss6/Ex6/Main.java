package JavaAdvanced.Ss6.Ex6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CinemaSimulation simulation = new CinemaSimulation();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Xem thống kê");
            System.out.println("4. Phát hiện deadlock");
            System.out.println("5. Thoát");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int rooms = scanner.nextInt();

                    System.out.print("Số vé/phòng: ");
                    int tickets = scanner.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = scanner.nextInt();

                    simulation.start(rooms, tickets, counters);

                    break;

                case 2:

                    simulation.stop();

                    break;

                case 3:

                    simulation.statistics();

                    break;

                case 4:

                    DeadlockDetector.detect();

                    break;

                case 5:

                    System.out.println("Đang dừng hệ thống...");
                    System.exit(0);
            }
        }
    }
}
