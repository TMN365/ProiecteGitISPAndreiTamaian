package Exercise3.safehome;

/**
 * Attempts is greater than or equal to 3. Too many attempts. It is shown in exception.
 */
public class TooManyAttemptsException extends Exception {
    private static final String DEFAULT_MESSAGE = "Too many attempts. The door will be locked now. Sorry";

    public TooManyAttemptsException() {
        super(DEFAULT_MESSAGE);
    }
}
