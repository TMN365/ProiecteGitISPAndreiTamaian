package Exercise2;

import java.time.LocalDateTime;

/**
 * Shows the curent state of a controller-observer.
 */
public class Controller implements Observer {

    @Override
    public void update(Object event, SensorType sensorType, int value) {
        System.out.println("[Controller (" + this + ")] The sensor " + sensorType + " has the value " + value + " on date " + LocalDateTime.now() + ".");
    }
}
