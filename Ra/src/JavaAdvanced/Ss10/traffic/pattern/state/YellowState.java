package JavaAdvanced.Ss10.traffic.pattern.state;

import JavaAdvanced.Ss10.traffic.entity.Direction;

public class YellowState implements TrafficLightState {
    private int duration = 3; // 3 giây đèn vàng

    @Override
    public String getColor() {
        return "🟡 VÀNG";
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Đèn chuyển từ VÀNG sang ĐỎ");
        context.setState(new RedState());
    }

    @Override
    public boolean canPass(Direction direction) {
        return false; // Cẩn thận khi đèn vàng
    }
}