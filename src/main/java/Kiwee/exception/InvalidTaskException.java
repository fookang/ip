package Kiwee.exception;

import Kiwee.utils.Ui;

public class InvalidTaskException extends KiweeException {
    public InvalidTaskException(int index) {
        super("Task #" + index + " does not exist \n" + Ui.SPACE +
                "Kiwee suggests counting again… slowly.");
    }
}
