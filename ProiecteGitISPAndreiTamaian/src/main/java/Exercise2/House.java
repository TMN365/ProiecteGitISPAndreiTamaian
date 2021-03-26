package Exercise2.Exercise2;

/**
 * Tests the functionality of events, controller and sensors.
 */
public class House {
    public static void main(String[] args) {

        Sensor sensor1 = new Sensor(SensorType.HUMIDITY);
        Sensor sensor2 = new Sensor(SensorType.TEMPERATURE);
        Sensor sensor3 = new Sensor(SensorType.PREASURE);
        //Controller boilerController = new Controller();
        Controller controller = new Controller();

        sensor1.register(controller);
        sensor2.register(controller);
        sensor3.register(controller);
        //sensor2.register(boilerController);
        for (int i = 0; i < 10; i++) {
            sensor1.readSensor();
        }
        System.out.println("***************************************************************************************************************************");

        for (int i = 0; i < 10; i++) {
            sensor2.readSensor();
        }
        System.out.println("******************************************************************************************************************************");

        for (int i = 0; i < 10; i++) {
            sensor3.readSensor();
        }
        System.out.println("***************************************************************************************************************************");
    }
}
