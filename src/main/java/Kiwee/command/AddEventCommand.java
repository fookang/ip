package Kiwee.command;

import Kiwee.exception.EndBeforeStartException;
import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Event;
import Kiwee.task.Task;
import Kiwee.utils.Dates;

import java.time.LocalDateTime;

public class AddEventCommand extends AddCommand {
    public AddEventCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("input is empty");
        }
        String[] words = input.split("/from", 2);
        if (words.length < 2) {
            throw new KiweeCommandException("Missing /from");
        }

        String description = words[0].trim();
        if (description.isEmpty()) {
            throw new KiweeCommandException("Description cannot be empty");
        }

        String time = words[1].trim();
        String[] details = time.split("/to", 2);

        if (details.length < 2) {
            throw new KiweeCommandException("Missing /to");
        }

        String fromStr = details[0].trim();
        String toStr = details[1].trim();

        if (fromStr.isEmpty() || toStr.isEmpty()) {
            throw new KiweeException("Start and end must be provided.");
        }

        LocalDateTime from = Dates.parseDate(fromStr.trim());
        LocalDateTime to = Dates.parseDate(toStr.trim());

        if (to.isBefore(from)) {
            throw new EndBeforeStartException();
        }

        return new Event(description, from, to);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
