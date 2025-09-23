package Kiwee.command;

import Kiwee.task.Task;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Storage;
import Kiwee.utils.Ui;

public class FindCommand implements Command{

    private final String key;

    public FindCommand(String key) {
        this.key = key.trim();
    }

    @Override
    public void execute(KiweeTaskList tasks, Storage storage) {
        if (key.isEmpty()) {
            Ui.printMessage("Kiwee don't know what to find without any input :(");
            return;
        }
        KiweeTaskList matches = new  KiweeTaskList();
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

    @Override
    public boolean isExit() {
        return false;
    }
}
