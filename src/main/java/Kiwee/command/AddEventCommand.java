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
            throw new KiweeException("That’s not an event, that’s silence. Say something!");
        }
        String[] words = input.split("/from", 2);
        if (words.length < 2) {
            throw new KiweeCommandException("Missing '/from' — Kiwee can’t guess when your event starts (yet).");
        }

        String description = words[0].trim();
        if (description.isEmpty()) {
            throw new KiweeCommandException("You forgot the description. Is this the mysterious unnamed event?");
        }

        String time = words[1].trim();
        String[] details = time.split("/to", 2);

        if (details.length < 2) {
            throw new KiweeCommandException("Missing '/to' — Is this event endless????");
        }

        String fromStr = details[0].trim();
        String toStr = details[1].trim();

        if (fromStr.isEmpty() || toStr.isEmpty()) {
            throw new KiweeCommandException("Both start and end must be provided. Time travel isn’t supported yet.");
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
