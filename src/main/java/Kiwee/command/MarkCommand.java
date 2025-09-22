package Kiwee.command;

import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class MarkCommand implements Command {
    private final int id;

    public MarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        tasks.get(id - 1).markAsDone();
        Ui.printTaskMarked(tasks.get(id - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
