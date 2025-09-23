package Kiwee.exception;

import Kiwee.utils.Ui;

public class KiweeCommandException extends KiweeException {
    public KiweeCommandException(String message) {
        super(message + "\n"
                + Ui.SPACE + "Looks like someone forgot the rules 🤔\n\n"
                + Ui.getCommandMessage());
    }
}
