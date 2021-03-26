package Exercise3.safehome;

/**
 * There are no tenant in system. It is shown in exception.
 */
public class NoTenantException extends Exception {
    private static final String DEFAULT_MESSAGE = "There are no tenants in this house.";

    public NoTenantException() {
        super(DEFAULT_MESSAGE);
    }
}
