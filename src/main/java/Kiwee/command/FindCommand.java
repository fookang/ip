package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

/**
 * Command to find tasks from the task list using a keyword.
 */
public class FindCommand implements Command {
    private final String key;

    /**
     * Creates a new FindCommand with the keyword to search for.
     *
     * @param key The keyword to search for in task descriptions
     */
    public FindCommand(String key) {
        this.key = key.trim();
    }

    /**
     * Executes the find command by searching for tasks containing the keyword.
     *
     * @param tasks   The task list to search through
     * @param storage The storage system
     * @throws KiweeException If the keyword is empty
     */
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        if (key.isEmpty()) {
            throw new KiweeException("Kiwee don't know what to find without any input :(");
        }
        KiweeTaskList matches = new KiweeTaskList();
        for (Task task : tasks) {
            if (task.getDescription().contains(key)) {
                matches.add(task);
            }
        }
        if (matches.isEmpty()) {
            Ui.printMessage("Kiwee can't find tasks with " + key);
        } else {
            Ui.printTask("Here you go!", matches);
        }
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as finding tasks does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
