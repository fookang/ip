package Kiwee.exception;

import Kiwee.utils.Ui;

public class WrongDateFormatException extends KiweeException {
    public WrongDateFormatException() {
        super("Kiwee tried to read your date, but I broke my brain \n"
                + Ui.SPACE + "Use yyyy-MM-dd, yyyy-MM-dd HH:mm, or HH:mm");
    }
}
