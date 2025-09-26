package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Abstract base class for all commands that add new tasks to the task list.
 */
public abstract class AddCommand implements Command {
    protected final String input;

    /**
     * Creates a new AddCommand with the specified user input.
     *
     * @param input The user input for creating a task
     */
    public AddCommand(String input) {
        this.input = input.trim();
    }

    /**
     * Abstract method to build a specific type of task from the user input.
     *
     * @return A new Task object created from the user input
     * @throws KiweeException If the input format is invalid
     */
    protected abstract Task buildTask() throws KiweeException;

    /**
     * Executes the add command by creating a new task and adding it to the task list.
     *
     * @param tasks   The task list to add the new task to
     * @param storage The storage system
     * @throws KiweeException If the input format is invalid
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        Task t = buildTask();
        tasks.add(t);
        Ui.printTaskAdded(t, tasks.size());
    }
}
