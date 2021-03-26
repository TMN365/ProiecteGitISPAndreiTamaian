package Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Retains in sensor the type and its value.
 */
public class Sensor {
    private SensorType sensorType;
    private int value;
    private List<Observer> observers = new ArrayList<Observer>();

    public Sensor(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    /**
     * Sets the value.
     * If the sensor type is humidity it sets a random number between 0 and 100(%).
     * If the sensor type is preasure it sets a random number between 1 and 30.
     * If the sensor type is temperature it sets a random number between -20 and 37.
     */
    public void readSensor() {
        Random random = new Random();
        if (sensorType.equals(SensorType.HUMIDITY)) {
            this.value = random.nextInt(101);
        }
        if (sensorType.equals(SensorType.PREASURE)) {
            this.value = random.nextInt(30) + 1;
        }
        if (sensorType.equals(SensorType.TEMPERATURE)) {
            this.value = random.nextInt(58) - 20;
        }
        changeState("Sensor's value has changed.");//changeState("");
    }

    /**
     * Notifies all the observers of an event transmitted as parameter.
     *
     * @param event - the event
     */
    private void changeState(Object event) {
        notifyAllObservers(event);
    }

    /**
     * Adds an observer (transmitted as parameter) in sensor's observator list.
     *
     * @param observer - the observer
     */
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * Updates all the observers of an event transmitted as parameter.
     *
     * @param event
     */
    private void notifyAllObservers(Object event) {
        for (Observer observer : observers) {
            observer.update(event, this.sensorType, this.value);
        }
    }
}
