package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;

/**
 * Interface for all commands in the application.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @param tasks   The task list to work with
     * @param storage The storage system
     * @throws KiweeException If command execution fails
     */
    void execute(KiweeTaskList tasks, Storage storage) throws KiweeException;

    /**
     * Checks if this command should exit the application.
     *
     * @return true if the app should exit, false otherwise
     */
    boolean isExit();
}
