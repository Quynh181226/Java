package JavaAdvanced.Ss10.traffic.pattern.state;

import JavaAdvanced.Ss10.traffic.entity.Direction;

public class RedState implements TrafficLightState {
    private int duration = 10; // 10 giây đèn đỏ

    @Override
    public String getColor() {
        return "ĐỎ";
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Đèn chuyển từ ĐỎ sang XANH");
        context.setState(new GreenState());
    }

    @Override
    public boolean canPass(Direction direction) {
        return false; // Không được đi khi đèn đỏ
    }
}