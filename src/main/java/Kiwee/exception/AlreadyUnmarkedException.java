package Kiwee.exception;

import Kiwee.task.Task;
import Kiwee.utils.Ui;

public class AlreadyUnmarkedException extends KiweeException {
    public AlreadyUnmarkedException(Task task) {
        super("Pro gamer move detected — unmarking what was never marked. \n" + Ui.SPACE + task);
    }
}
