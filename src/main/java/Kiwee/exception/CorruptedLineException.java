package Kiwee.exception;

/**
 * Exception thrown when attempting to read a data file that cannot be interpreted.
 * This occurs when the stored data format is corrupted or invalid.
 */
public class CorruptedLineException extends KiweeException {

    /**
     * Creates a new CorruptedLineException with a message about the corrupted data.
     *
     * @param message The corrupted data line that could not be interpreted
     */
    public CorruptedLineException(String message) {
        super("Kiwee cannot understand this " + message);
    }
}
