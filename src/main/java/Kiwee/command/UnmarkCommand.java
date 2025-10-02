package Kiwee.command;

import Kiwee.exception.AlreadyUnmarkedException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to mark a task as not done.
 */
public class UnmarkCommand implements Command {
    private final int id;

    /**
     * Creates a new UnmarkCommand with the task ID to mark as not done.
     *
     * @param id The ID of the task to mark as not done
     */
    public UnmarkCommand(int id) {
        this.id = id;
    }

    /**
     * Executes the unmark command by marking the task as not done in the task list.
     *
     * @param tasks   The task list containing the task to unmark
     * @param storage The storage system
     * @throws AlreadyUnmarkedException If the task is already marked as not done
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws AlreadyUnmarkedException {
        if (!tasks.get(id - 1).isDone()) {
            throw new AlreadyUnmarkedException(tasks.get(id - 1));
        }
        tasks.get(id - 1).markAsUndone();
        Ui.printTaskUnmarked(tasks.get(id - 1));
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as marking a task as not done does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
