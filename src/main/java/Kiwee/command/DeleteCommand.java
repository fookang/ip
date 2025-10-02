package Kiwee.command;

import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to delete a task from the task list.
 */
public class DeleteCommand implements Command {
    private final int id;

    /**
     * Creates a new DeleteCommand with the task ID to delete.
     *
     * @param id The ID of the task to delete
     */
    public DeleteCommand(int id) {
        this.id = id;
    }

    /**
     * Executes the delete command by removing the task from the task list.
     *
     * @param tasks   The task list to remove the task from
     * @param storage The storage system
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        Task remove = tasks.remove(id - 1);
        Ui.printTaskDeleted(remove, tasks.size());
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as deleting a task does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
