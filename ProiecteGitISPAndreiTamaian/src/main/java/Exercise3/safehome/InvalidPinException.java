package Exercise3.safehome;

/**
 * Shows that the pin is incorrect in exception.
 */
public class InvalidPinException extends Exception {
    private static final String DEFAULT_MESSAGE = "Invalid Pin";

    public InvalidPinException() {
        super(DEFAULT_MESSAGE);
    }
}
