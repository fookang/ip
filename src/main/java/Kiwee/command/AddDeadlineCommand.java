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
            throw new KiweeException("That’s not a deadline, that’s silence. Say something!");
        }

        String[] words = input.split("/by", 2);
        if (words.length < 2) {
            throw new KiweeException("Missing '/by' — deadlines need dates, not vibes.");
        }

        String description = words[0].trim();
        if (description.isEmpty()) {
            throw new KiweeException("Describe the task, please. Kiwee can’t read minds (yet).");
        }

        String byStr = words[1].trim();
        if (byStr.isEmpty()) {
            throw new KiweeException("When is it due? Stop procrastinating!!");
        }

        LocalDateTime by = Dates.parseDate(words[1].trim());
        return new Deadline(description, by);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
