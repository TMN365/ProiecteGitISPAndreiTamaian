package Exercise3.safehome;

/**
 * Tester of DoorLockController
 */
public class SafeHome {

    public static void main(String[] args) {
        /*
        AccessKey accessKey1 = new AccessKey("1234");
        AccessKey accessKey2 = new AccessKey("0000");
        AccessKey accessKey3 = new AccessKey("2020");
        AccessKey accessKey4 = new AccessKey("1011");
        List<AccessKey> accessKeyList = new ArrayList<>();
        accessKeyList.add(accessKey1);
        accessKeyList.add(accessKey2);
        accessKeyList.add(accessKey3);
        accessKeyList.add(accessKey4);

        Tenant tenant1 = new Tenant("Andrei");
        Tenant tenant2 = new Tenant("Andreea");
        Tenant tenant3 = new Tenant("Maria");
        Tenant tenant4 = new Tenant("Roxana");
        List<Tenant> tenants = new ArrayList<>();
        tenants.add(tenant1);
        tenants.add(tenant2);
        tenants.add(tenant3);
        tenants.add(tenant4);

         */
        Door door = new Door(DoorStatus.CLOSE);
        DoorLockController doorLockController = new DoorLockController(door);
        try {
            doorLockController.addTenant("0000", "Razvan");
        } catch (TenantAlreadyExistsException  e  ) {
            System.err.println("Caught TenantAlreadyExistsException: "
                    + e.getMessage());
        }
        ;
        try {
            doorLockController.addTenant("0002", "Ale");
        } catch (TenantAlreadyExistsException e) {
            System.err.println("Caught TenantAlreadyExistsException: "
                    + e.getMessage());
        }
        ;
        try {
            doorLockController.addTenant("0020", "Andrei");
        } catch (TenantAlreadyExistsException e) {
            System.err.println("Caught TenantAlreadyExistsException: "
                    + e.getMessage());
        }
        ;
        try {
            doorLockController.addTenant("0022", "Andrei");
        } catch (TenantAlreadyExistsException e) {
            System.err.println("Caught TenantAlreadyExistsException: "
                    + e.getMessage());
        }
        ;

        try {
            doorLockController.enterPin("1234");
        } catch (InvalidPinException e) {
            System.err.println("Caught InvalidPinException: "
                    + e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.err.println("Caught TooManyAttemptsException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        };
        try {
            doorLockController.enterPin("4958");
        } catch (InvalidPinException e) {
            System.err.println("Caught InvalidPinException: "
                    + e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.err.println("Caught TooManyAttemptsException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        };
        try {
            doorLockController.enterPin("777");
        } catch (InvalidPinException e) {
            System.err.println("Caught InvalidPinException: "
                    + e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.err.println("Caught TooManyAttemptsException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        };

        try {
            doorLockController.enterPin("0020");
        } catch (InvalidPinException e) {
            System.err.println("Caught InvalidPinException: "
                    + e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.err.println("Caught TooManyAttemptsException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        };
        try {
            doorLockController.enterPin("MasterKeyValue");
        } catch (InvalidPinException e) {
            System.err.println("Caught InvalidPinException: "
                    + e.getMessage());
        } catch (TooManyAttemptsException e) {
            System.err.println("Caught TooManyAttemptsException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        };

        try{
            doorLockController.removeTenant("Alexandru");
        }catch (TenantNotFoundException e){
            System.err.println("Caught TenantNotFoundException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        }
        try{
            doorLockController.removeTenant("Ale");
        }catch (TenantNotFoundException e){
            System.err.println("Caught TenantNotFoundException: "
                    + e.getMessage());
        } catch (NoTenantException e) {
            System.err.println("Caught NoTenantException: "
                    + e.getMessage());
        }
        doorLockController.getAccessLogs();
    }
}
