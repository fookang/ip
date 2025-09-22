package Kiwee.command;

import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class UnmarkCommand implements Command {
    private final int id;

    public UnmarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        tasks.get(id - 1).markAsUndone();
        Ui.printTaskUnmarked(tasks.get(id - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
