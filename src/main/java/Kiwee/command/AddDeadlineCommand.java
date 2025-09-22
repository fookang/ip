package Kiwee.command;

import Kiwee.exception.KiweeCommandException;
import Kiwee.task.Deadline;
import Kiwee.task.Task;

public class AddDeadlineCommand extends AddCommand {
    public AddDeadlineCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeCommandException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("Input is empty");
        }

        String[] words = input.split("/by", 2);
        if (words.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }
        String description = words[0].trim();
        String by = words[1].trim();

        return new Deadline(description, by);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
