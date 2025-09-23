package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;

public interface Command {
    void execute(KiweeTaskList tasks, Storage storage) throws KiweeException;

    boolean isExit();
}
