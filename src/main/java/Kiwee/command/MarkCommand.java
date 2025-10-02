package Kiwee.command;

import Kiwee.exception.AlreadyMarkedException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to mark a task as done.
 */
public class MarkCommand implements Command {
    private final int id;

    /**
     * Creates a new MarkCommand with the task ID to mark as done.
     *
     * @param id The ID of the task to mark as done
     */
    public MarkCommand(int id) {
        this.id = id;
    }

    /**
     * Executes the mark command by marking the task as done in the task list.
     *
     * @param tasks   The task list containing the task to mark
     * @param storage The storage system
     * @throws AlreadyMarkedException If the task is already marked as done
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws AlreadyMarkedException {
        if (tasks.get(id - 1).isDone()) {
            throw new AlreadyMarkedException(tasks.get(id - 1));
        }
        tasks.get(id - 1).markAsDone();
        Ui.printTaskMarked(tasks.get(id - 1));
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as marking a task as done does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
