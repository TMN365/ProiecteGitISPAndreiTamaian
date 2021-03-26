package Exercise3.safehome;

/**
 * Tenant already exists in system. It is shown in exception.
 */
public class TenantAlreadyExistsException extends Exception {
    private static final String DEFAULT_MESSAGE ="This tenant already exists. Try another name.";

    public TenantAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }
}
