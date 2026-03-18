package JavaAdvanced.Ss10.traffic.entity;

public class StandardVehicle extends Vehicle {
    private boolean hasStopped = false;

    public StandardVehicle(String id, String type, int speed, Direction direction) {
        super(id, type, speed, 1, direction);
    }

    @Override
    public void move() {
        if (!hasStopped) {
            System.out.println(String.format("[Time: %ds] %s #%s đang di chuyển trên đường %s",
                    (System.currentTimeMillis() / 1000) % 100, type, id, direction));
            currentPosition.setX(currentPosition.getX() + 1);
        }
    }

    @Override
    public void stop() {
        this.hasStopped = true;
        System.out.println(String.format("%s #%s dừng lại vì đèn đỏ", type, id));
    }

    @Override
    public void emergencyOverride() {
        // Standard vehicles don't have emergency override
    }

    public void resume() {
        this.hasStopped = false;
    }
}