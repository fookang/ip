package Kiwee.exception;

/**
 * Exception thrown when user sets an Event task's end time before its start time.
 * This prevents users from inputting data that doesn't make logical sense.
 */
public class EndBeforeStartException extends KiweeException {

    /**
     * Creates a new EndBeforeStartException with a message about the invalid time ordering.
     */
    public EndBeforeStartException() {
        super("Wow! You finish your task before you started!");
    }
}
