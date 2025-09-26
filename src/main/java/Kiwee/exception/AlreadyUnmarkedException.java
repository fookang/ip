package Kiwee.exception;

import Kiwee.task.Task;
import Kiwee.utils.Ui;

/**
 * Exception thrown when attempting to unmark a task as not done that is already marked as not done.
 * This prevents users from repeatedly marking the same task as incomplete.
 */
public class AlreadyUnmarkedException extends KiweeException {

    /**
     * Creates a new AlreadyUnmarkedException with a message about the already incomplete task.
     *
     * @param task The task that was already marked as not done
     */
    public AlreadyUnmarkedException(Task task) {
        super("Pro gamer move detected — unmarking what was never marked. \n" + Ui.SPACE + task);
    }
}
