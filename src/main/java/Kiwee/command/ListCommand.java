package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class ListCommand implements Command {
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) throws KiweeException {
        Ui.printTask(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
