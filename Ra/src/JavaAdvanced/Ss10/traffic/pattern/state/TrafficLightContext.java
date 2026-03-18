package JavaAdvanced.Ss10.traffic.pattern.state;

import JavaAdvanced.Ss10.traffic.entity.Direction;
import JavaAdvanced.Ss10.traffic.pattern.observer.TrafficLightObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficLightContext {
    private TrafficLightState currentState;
    private List<TrafficLightObserver> observers = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private boolean isRunning = true;

    public TrafficLightContext() {
        this.currentState = new RedState(); // Bắt đầu với đèn đỏ
        startLightCycle();
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
        notifyObservers();
    }

    public String getCurrentColor() {
        return currentState.getColor();
    }

    public boolean canPass(Direction direction) {
        return currentState.canPass(direction);
    }

    public void addObserver(TrafficLightObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TrafficLightObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (TrafficLightObserver observer : observers) {
            observer.update(currentState.getColor(), currentState.canPass(null));
        }
    }

    private void startLightCycle() {
        scheduler.scheduleAtFixedRate(() -> {
            if (isRunning) {
                currentState.next(this);
            }
        }, currentState.getDuration(), currentState.getDuration(), TimeUnit.SECONDS);
    }

    public void stop() {
        isRunning = false;
        scheduler.shutdown();
    }
}