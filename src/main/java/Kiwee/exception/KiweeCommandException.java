package Kiwee.exception;

import Kiwee.utils.Ui;

/**
 * Exception thrown when user inputs an invalid or unrecognized command.
 * This provides helpful feedback and displays available commands to the user.
 */
public class KiweeCommandException extends KiweeException {

    /**
     * Creates a new KiweeCommandException with a custom error message.
     * The exception displays the error message along with available commands.
     *
     * @param message The error message describing the invalid command
     */
    public KiweeCommandException(String message) {
        super(message + "\n"
                + Ui.SPACE + "Looks like someone forgot the rules \n\n"
                + Ui.getCommandMessage());
    }
}
