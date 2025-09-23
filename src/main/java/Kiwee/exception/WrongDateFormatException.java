package Kiwee.exception;

import Kiwee.utils.Ui;

public class WrongDateFormatException extends KiweeException {
    public WrongDateFormatException() {
        super("Kiwee understood your command but your date format is wrong \n"
        + Ui.SPACE + "Use yyyy-MM-dd, yyyy-MM-dd HH:mm or HH:mm");
    }
}
