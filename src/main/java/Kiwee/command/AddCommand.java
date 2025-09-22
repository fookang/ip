package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;


public abstract class AddCommand implements Command {
    protected final String input;

    public AddCommand(String input) {
        this.input = input.trim();
    }

    protected abstract Task buildTask() throws KiweeException;

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        Task t = buildTask();
        tasks.add(t);
        Ui.printTaskAdded(t, tasks.size());
    }
}
