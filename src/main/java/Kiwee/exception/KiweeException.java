package Kiwee.exception;

/**
 * Base exception class for all Kiwee application-specific exceptions.
 */
public class KiweeException extends Exception {

    /**
     * Creates a new KiweeException with the specified error message.
     *
     * @param message The error message describing what went wrong
     */
    public KiweeException(String message) {
        super(message);
    }
}
