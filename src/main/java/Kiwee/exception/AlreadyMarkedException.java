package Kiwee.exception;

import Kiwee.task.Task;
import Kiwee.utils.Ui;

public class AlreadyMarkedException extends KiweeException {
    public AlreadyMarkedException(Task task) {
        super("You’ve completed this task… again. Want a medal? \n" + Ui.SPACE + task);
    }
}
