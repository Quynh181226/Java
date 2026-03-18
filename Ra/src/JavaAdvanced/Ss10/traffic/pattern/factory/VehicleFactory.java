package JavaAdvanced.Ss10.traffic.pattern.factory;

import JavaAdvanced.Ss10.traffic.entity.Direction;
import JavaAdvanced.Ss10.traffic.entity.PriorityVehicle;
import JavaAdvanced.Ss10.traffic.entity.StandardVehicle;
import JavaAdvanced.Ss10.traffic.entity.Vehicle;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class VehicleFactory {
    private static final String[] VEHICLE_TYPES = {"Xe máy", "Ô tô", "Xe tải", "Xe cứu thương"};
    private static final int[] SPEEDS = {3, 2, 1, 4};
    private static final Random random = new Random();
    private static AtomicInteger counter = new AtomicInteger(1);

    public static Vehicle createRandomVehicle() {
        int index = random.nextInt(VEHICLE_TYPES.length);
        String type = VEHICLE_TYPES[index];
        int speed = SPEEDS[index];
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        String id = String.format("%02d", counter.getAndIncrement());

        if (type.equals("Xe cứu thương")) {
            return new PriorityVehicle(id, type, speed, direction);
        } else {
            return new StandardVehicle(id, type, speed, direction);
        }
    }

    public static Vehicle createVehicle(String type, Direction direction) {
        String id = String.format("%02d", counter.getAndIncrement());
        int speed = 0;

        switch (type) {
            case "Xe máy": speed = 3; break;
            case "Ô tô": speed = 2; break;
            case "Xe tải": speed = 1; break;
            case "Xe cứu thương":
                return new PriorityVehicle(id, type, 4, direction);
        }

        return new StandardVehicle(id, type, speed, direction);
    }
}