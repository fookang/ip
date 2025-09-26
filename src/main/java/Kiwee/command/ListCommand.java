package Kiwee.command;

import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to list all the tasks in the task list.
 */
public class ListCommand implements Command {

    /**
     * Executes the list command by displaying all tasks in the task list.
     *
     * @param tasks   The task list to display
     * @param storage The storage system
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        Ui.printTask(tasks);
    }

    /**
     * Indicates whether this command should exit the application.
     *
     * @return false, as listing tasks does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
