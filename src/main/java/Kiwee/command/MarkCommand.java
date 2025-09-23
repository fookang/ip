package Kiwee.command;

import Kiwee.exception.AlreadyMarkedException;
import Kiwee.exception.KiweeException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class MarkCommand implements Command {
    private final int id;

    public MarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        if (tasks.get(id - 1).isDone()) {
            throw new AlreadyMarkedException(tasks.get(id - 1));
        }
        tasks.get(id - 1).markAsDone();
        Ui.printTaskMarked(tasks.get(id - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
