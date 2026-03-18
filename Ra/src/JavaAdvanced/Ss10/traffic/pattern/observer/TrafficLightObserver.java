package JavaAdvanced.Ss10.traffic.pattern.observer;

public interface TrafficLightObserver {
    void update(String color, boolean canPass);
}