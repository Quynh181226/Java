package JavaAdvanced.Ss10.traffic.pattern.state;

import JavaAdvanced.Ss10.traffic.entity.Direction;

public interface TrafficLightState {
    String getColor();
    int getDuration();
    void next(TrafficLightContext context);
    boolean canPass(Direction direction);
}