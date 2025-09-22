package Kiwee.command;

import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class DeleteCommand implements Command {
    private final int id;

    public DeleteCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        Task remove = tasks.remove(id - 1);
        Ui.printTaskDeleted(remove, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
