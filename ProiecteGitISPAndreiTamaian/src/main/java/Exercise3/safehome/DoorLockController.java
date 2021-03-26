package Exercise3.safehome;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Allows only some member to enter the house.
 * Adds new tenants.
 * Removes tenants.
 */
public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccessKey> validAccess;
    private Door door;
    private List<AccessLog> accessLogList;
    private String MASTER_KEY;
    private String MASTER_TENANT_NAME;
    private static int count;

    public DoorLockController(Door door) {
        this.validAccess = null;
        this.door = door;
        this.accessLogList = new ArrayList<>();
        this.MASTER_KEY = ControllerInterface.MASTER_KEY;
        this.MASTER_TENANT_NAME = ControllerInterface.MASTER_TENANT_NAME;
        this.count = 0;
    }

    /**
     * Opens the door or closes it.
     * It changes status if the number of attempts is lower than 3 and the pin is correct.
     * It changes status if master key is used.
     * It does not change status if the number of attempts is greater or equal to 3.
     *
     * @param pin - pin value
     * @return - door status
     * @throws InvalidPinException - Incorrect pin according to system
     * @throws TooManyAttemptsException - Attempts greater or equal to 3
     * @throws NoTenantException - No tenants in system
     */
    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException, NoTenantException {
        if (validAccess == null) {
            accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), "No tenant. The house is empty."));
            throw new NoTenantException();
        }
        if (pin == MASTER_KEY) {
            if (door.getStatus() == DoorStatus.CLOSE) {
                System.out.println("Success. The door is OPEN");
                door.unlockDoor();
                accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), ""));
                count = 0;
                return door.getStatus();
            }
            if (door.getStatus() == DoorStatus.OPEN) {
                System.out.println("Success. The door is CLOSED");
                door.lockDoor();
                accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), ""));
                count = 0;
                return door.getStatus();
            }
        }

        if (count >= 2) {
            accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), "Too many attempts."));
            throw new TooManyAttemptsException();
        }

        if (pin == null || pin == "") {
            accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), "Entered pin is empty. Try again."));
            throw new InvalidPinException();
        }

        final AccessKey accessKeyFromPin = new AccessKey(pin);
        Set<Map.Entry<Tenant, AccessKey>> tenantMap = validAccess.entrySet();


        for (Map.Entry<Tenant, AccessKey> it : tenantMap) {
            if (it.getValue().equals(accessKeyFromPin)) { // it.getValue().equals(pin) sau aici pot face cu getValue().getPin()==pin Vedem daca iese mai intai cu equals.
                if (door.getStatus() == DoorStatus.CLOSE) {
                    System.out.println("Succes. The door is OPEN");
                    door.unlockDoor();
                    accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), ""));
                    count = 0;
                    return door.getStatus();
                }
                if (door.getStatus() == DoorStatus.OPEN) {
                    System.out.println("Success. The door is CLOSED");
                    door.lockDoor();
                    accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), ""));
                    count = 0;
                    return door.getStatus();
                }
            }
        }
        System.out.println("Fail. The door is still " + door.getStatus());
        count += 1;
        accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Enter pin", door.getStatus(), "Incorect pin"));
        throw new InvalidPinException();
        //return door.getStatus();
    }

    /**
     * Adds a tenant name and password to the door lock's memory.
     *
     * @param pin  - pin to be added in the system
     * @param tenantName - name of tenant to be added in the system
     * @throws TenantAlreadyExistsException - tenant already exists in system
     */
    @Override
    public void addTenant(String pin, String tenantName) throws TenantAlreadyExistsException {

        if (validAccess == null) {
            validAccess = new HashMap<Tenant, AccessKey>();
        }
        Set<Map.Entry<Tenant, AccessKey>> tenantMap = validAccess.entrySet();
        //Check if the tenant exists in Map
        for (Map.Entry<Tenant, AccessKey> it : tenantMap) {
            if (it.getKey().getName() == tenantName) {
                accessLogList.add(new AccessLog(tenantName, LocalDateTime.now(), "Add Tenant", door.getStatus(), "Tenant already exists."));
                throw new TenantAlreadyExistsException();
            }

        }
        validAccess.put(new Tenant(tenantName), new AccessKey(pin));
        accessLogList.add(new AccessLog(tenantName, LocalDateTime.now(), "Add Tenant", door.getStatus(), ""));
    }

    /**
     *
     * @param name - tenant name to be removed
     * @throws TenantNotFoundException - tenant name's not found in the system
     * @throws NoTenantException - no tenants in the system
     */
    @Override
    public void removeTenant(String name) throws TenantNotFoundException, NoTenantException {
        if (validAccess == null) {
            accessLogList.add(new AccessLog("No name", LocalDateTime.now(), "Remove Tenant", door.getStatus(), "No tenants in house."));
            throw new NoTenantException();
        }
        Set<Map.Entry<Tenant, AccessKey>> tenantMap = validAccess.entrySet();
        for (Map.Entry<Tenant, AccessKey> it : tenantMap) {
            if (it.getKey().getName() == name) {
                validAccess.remove(it.getKey());
                accessLogList.add(new AccessLog(name, LocalDateTime.now(), "Remove Tenant", door.getStatus(), ""));
                return;
            }
        }

        accessLogList.add(new AccessLog(name, LocalDateTime.now(), "Remove Tenant", door.getStatus(), "Wrong name."));
        throw new TenantNotFoundException();
    }

    public List<AccessLog> getAccessLogs() {
        for (AccessLog aux : accessLogList) {
            System.out.println(aux.toString());
        }
        return accessLogList;
    }


}
