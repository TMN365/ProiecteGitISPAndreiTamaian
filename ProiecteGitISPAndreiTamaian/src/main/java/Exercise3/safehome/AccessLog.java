package Exercise3.safehome;

import java.time.LocalDateTime;

/**
 * Information of the operation executed by the inteligent door. It shows the tenant name, the date and time, the operation ("enter pin","add tenant","remove tenant"),
 * the door status and the error message ("","No tenant. The house is empty.","Too many attempts.","Entered pin is empty. Try again.","Wrong name.","No tenants in house.","Tenant already exists.","Incorect pin").
 * Used by DoorLockController.
 *
 */
public class AccessLog {
    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "AccessLog{" +
                "tenantName='" + tenantName + '\'' +
                ", dateTime=" + dateTime +
                ", operation='" + operation + '\'' +
                ", doorStatus=" + doorStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
