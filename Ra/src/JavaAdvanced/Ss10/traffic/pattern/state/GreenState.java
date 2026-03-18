package JavaAdvanced.Ss10.traffic.pattern.state;

import JavaAdvanced.Ss10.traffic.entity.Direction;

public class GreenState implements TrafficLightState {
    private int duration = 15; // 15 giây đèn xanh

    @Override
    public String getColor() {
        return "XANH";
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Đèn chuyển từ XANH sang VÀNG");
        context.setState(new YellowState());
    }

    @Override
    public boolean canPass(Direction direction) {
        return true; // Được đi khi đèn xanh
    }
}