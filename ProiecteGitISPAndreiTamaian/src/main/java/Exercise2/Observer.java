package Exercise2;

/**
 * Updates an observer.
 */
public interface Observer {
    public abstract void update(Object event, SensorType sensorType, int value);
}
