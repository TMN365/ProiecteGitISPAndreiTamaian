package Exercise3.safehome;

/**
 * Shows if the door is open or close.
 */
public class Door {
    private DoorStatus status;

    public Door(DoorStatus status) {
        this.status = status;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void lockDoor() {
        this.status = DoorStatus.CLOSE;
    }

    public void unlockDoor() {
        this.status = DoorStatus.OPEN;
    }

}
