package JavaAdvanced.Ss10.traffic.engine;

import JavaAdvanced.Ss10.traffic.entity.Direction;
import JavaAdvanced.Ss10.traffic.entity.PriorityVehicle;
import JavaAdvanced.Ss10.traffic.entity.Vehicle;
import JavaAdvanced.Ss10.traffic.exception.CollisionException;
import JavaAdvanced.Ss10.traffic.exception.TrafficJamException;
import JavaAdvanced.Ss10.traffic.pattern.factory.VehicleFactory;
import JavaAdvanced.Ss10.traffic.pattern.state.TrafficLightContext;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Intersection {
    private final TrafficLightContext trafficLight;
    private final ConcurrentLinkedQueue<Vehicle> vehicleQueue;
    private final Map<Direction, BlockingQueue<Vehicle>> waitingLanes;
    private final ReentrantLock intersectionLock;
    private final AtomicInteger vehiclesPassed;
    private final AtomicInteger trafficJamCount;
    private static final int MAX_QUEUE_SIZE = 10;
    private volatile boolean isRunning = true;

    public Intersection() {
        this.trafficLight = new TrafficLightContext();
        this.vehicleQueue = new ConcurrentLinkedQueue<>();
        this.waitingLanes = new ConcurrentHashMap<>();
        this.intersectionLock = new ReentrantLock(true);
        this.vehiclesPassed = new AtomicInteger(0);
        this.trafficJamCount = new AtomicInteger(0);

        // Khởi tạo hàng đợi cho mỗi làn đường
        for (Direction dir : Direction.values()) {
            waitingLanes.put(dir, new LinkedBlockingQueue<>());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleQueue.offer(vehicle);
        System.out.println(String.format("🚗 Phương tiện mới: %s #%s hướng %s",
                vehicle.getType(), vehicle.getId(), vehicle.getDirection().getVietnamese()));
    }

    public void processVehicles() {
        ExecutorService vehicleExecutor = Executors.newCachedThreadPool();

        while (isRunning) {
            Vehicle vehicle = vehicleQueue.poll();
            if (vehicle != null) {
                vehicleExecutor.submit(() -> {
                    try {
                        navigateIntersection(vehicle);
                    } catch (TrafficJamException e) {
                        System.err.println(e.getMessage());
                        trafficJamCount.incrementAndGet();
                    } catch (CollisionException e) {
                        System.err.println("⚠️ CẢNH BÁO VA CHẠM: " + e.getMessage());
                    }
                });
            }

            try {
                Thread.sleep(500); // Giảm tải CPU
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        vehicleExecutor.shutdown();
    }

    private void navigateIntersection(Vehicle vehicle) throws TrafficJamException, CollisionException {
        Direction dir = vehicle.getDirection();
        BlockingQueue<Vehicle> lane = waitingLanes.get(dir);

        // Kiểm tra kẹt xe
        if (lane.size() >= MAX_QUEUE_SIZE) {
            throw new TrafficJamException(String.format(
                    "KẸT XE: Làn đường %s đã đầy với %d xe đang chờ!",
                    dir.getVietnamese(), lane.size()));
        }

        try {
            lane.put(vehicle);

            // Xe cứu thương được ưu tiên
            if (vehicle instanceof PriorityVehicle) {
                handleEmergencyVehicle(vehicle, lane);
                return;
            }

            // Xử lý xe thường
            while (!trafficLight.canPass(dir) || !intersectionLock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(String.format("%s #%s đang chờ đèn xanh tại hướng %s",
                        vehicle.getType(), vehicle.getId(), dir.getVietnamese()));
                vehicle.stop();
                Thread.sleep(1000);
            }

            try {
                // Đi qua ngã tư
                vehicle.move();
                vehiclesPassed.incrementAndGet();
                System.out.println(String.format("✅ %s #%s đã qua ngã tư thành công",
                        vehicle.getType(), vehicle.getId()));
            } finally {
                intersectionLock.unlock();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lane.remove(vehicle);
        }
    }

    private void handleEmergencyVehicle(Vehicle vehicle, BlockingQueue<Vehicle> lane) {
        System.out.println(String.format("🚨 XE CỨU THƯƠNG #%s được ưu tiên qua ngã tư!",
                vehicle.getId()));

        if (intersectionLock.tryLock()) {
            try {
                vehicle.emergencyOverride();
                vehiclesPassed.incrementAndGet();
            } finally {
                intersectionLock.unlock();
            }
        } else {
            // Nếu không lấy được lock, vẫn cho xe cứu thương qua (ưu tiên)
            vehicle.emergencyOverride();
            vehiclesPassed.incrementAndGet();
        }
    }

    public void startSimulation() {
        System.out.println("🚦 BẮT ĐẦU MÔ PHỎNG GIAO THÔNG THÔNG MINH 🚦");
        System.out.println("==============================================");

        // Thread xử lý xe
        Thread processorThread = new Thread(this::processVehicles);
        processorThread.setDaemon(false);
        processorThread.start();

        // Thread sinh xe tự động
        ScheduledExecutorService vehicleGenerator = Executors.newScheduledThreadPool(1);
        vehicleGenerator.scheduleAtFixedRate(() -> {
            if (isRunning) {
                Vehicle newVehicle = VehicleFactory.createRandomVehicle();
                addVehicle(newVehicle);
            }
        }, 2, 3, TimeUnit.SECONDS);

        // Dừng sau 60 giây
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        stopSimulation();
        vehicleGenerator.shutdown();
    }

    public void stopSimulation() {
        isRunning = false;
        trafficLight.stop();
        printStatistics();
    }

    private void printStatistics() {
        System.out.println("\n📊 THỐNG KÊ MÔ PHỎNG 📊");
        System.out.println("=================================");
        System.out.println("Tổng số xe đã qua ngã tư: " + vehiclesPassed.get());
        System.out.println("Số lần kẹt xe: " + trafficJamCount.get());

        // Thống kê theo loại xe
        Map<String, Long> vehicleTypeCount = vehicleQueue.stream()
                .collect(Collectors.groupingBy(Vehicle::getType, Collectors.counting()));

        System.out.println("\nPhương tiện đang lưu thông:");
        vehicleTypeCount.forEach((type, count) ->
                System.out.println("  - " + type + ": " + count + " xe"));
    }
}