package Kiwee.command;

import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to exit the application.
 */
public class ByeCommand implements Command {

    /**
     * Executes the bye command by displaying a farewell message and saving all tasks.
     *
     * @param tasks   The task list to save to storage
     * @param storage The storage system
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        Ui.BYE_MESSAGE();
        storage.save(tasks);
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return true, as this command terminates the application
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
