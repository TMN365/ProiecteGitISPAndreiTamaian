package Exercise3.safehome;

/**
 * Tenant is not in system. It is shown in exception.
 */
public class TenantNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Tenant not found. Try another name.";

    public TenantNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
