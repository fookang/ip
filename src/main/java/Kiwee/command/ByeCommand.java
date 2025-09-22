package Kiwee.command;

import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class ByeCommand implements Command{
    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        Ui.BYE_MESSAGE();
        storage.save(tasks);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
