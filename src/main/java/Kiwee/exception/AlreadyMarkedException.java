package Kiwee.exception;

import Kiwee.task.Task;
import Kiwee.utils.Ui;

/**
 * Exception thrown when attempting to mark a task as done that is already marked as done.
 * This prevents users from repeatedly marking the same task as completed.
 */
public class AlreadyMarkedException extends KiweeException {

    /**
     * Creates a new AlreadyMarkedException with a message about the already completed task.
     *
     * @param task The task that was already marked as done
     */
    public AlreadyMarkedException(Task task) {
        super("You’ve completed this task… again. Want a medal? \n" + Ui.SPACE + task);
    }
}
