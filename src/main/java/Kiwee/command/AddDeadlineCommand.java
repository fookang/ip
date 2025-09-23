package Kiwee.command;

import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Deadline;
import Kiwee.task.Task;
import Kiwee.utils.Dates;

import java.time.LocalDateTime;

public class AddDeadlineCommand extends AddCommand {
    public AddDeadlineCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("Input is empty");
        }

        String[] words = input.split("/by", 2);
        if (words.length < 2) {
            throw new KiweeCommandException("Missing /by");
        }

        String description = words[0].trim();
        if (description.isEmpty()) {
            throw new KiweeCommandException("Description cannot empty");
        }

        String byStr = words[1].trim();
        if (byStr.isEmpty()) {
            throw new KiweeCommandException("Deadline must be provided");
        }

        LocalDateTime by = Dates.parseDate(words[1].trim());
        return new Deadline(description, by);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
