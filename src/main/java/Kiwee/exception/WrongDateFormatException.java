package Kiwee.exception;

import Kiwee.utils.Ui;

/**
 * Exception thrown when user inputs an invalid or unrecognized date format.
 * This provides helpful feedback and displays the accepted date formats to the user.
 */
public class WrongDateFormatException extends KiweeException {

    /**
     * Creates a new WrongDateFormatException with a message about the invalid date format
     * and provides the accepted date formats to help the user.
     */
    public WrongDateFormatException() {
        super("Kiwee tried to read your date, but I broke my brain \n"
                + Ui.SPACE + "Use yyyy-MM-dd, yyyy-MM-dd HH:mm, or HH:mm");
    }
}
