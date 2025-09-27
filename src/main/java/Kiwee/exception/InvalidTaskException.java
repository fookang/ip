package Kiwee.exception;

import Kiwee.utils.Ui;

/**
 * Exception thrown when user inputs an invalid index for a Task.
 * This prevents the program from accessing invalid memory addresses or array indices.
 */
public class InvalidTaskException extends KiweeException {

    /**
     * Creates a new InvalidTaskException with a message about the invalid index.
     *
     * @param index The index which the user tried to access
     */
    public InvalidTaskException(int index) {
        super("Task #" + index + " does not exist \n" + Ui.SPACE +
                "Kiwee suggests counting again... slowly.");
    }
}
