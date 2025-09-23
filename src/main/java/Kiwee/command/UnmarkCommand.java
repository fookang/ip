package Kiwee.command;

import Kiwee.exception.AlreadyUnmarkedException;
import Kiwee.exception.KiweeException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class UnmarkCommand implements Command {
    private final int id;

    public UnmarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        if (!tasks.get(id - 1).isDone()) {
            throw new AlreadyUnmarkedException(tasks.get(id - 1));
        }
        tasks.get(id - 1).markAsUndone();
        Ui.printTaskUnmarked(tasks.get(id - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
