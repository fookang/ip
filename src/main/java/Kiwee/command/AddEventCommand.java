package Kiwee.command;

import Kiwee.exception.EndBeforeStartException;
import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Event;
import Kiwee.task.Task;
import Kiwee.utils.Dates;

import java.time.LocalDateTime;

/**
 * Command for adding an event task to the task list.
 */
public class AddEventCommand extends AddCommand {

    /**
     * Creates a new AddEventCommand with the specified user input.
     *
     * @param input The user input containing the event description, start date and end date
     */
    public AddEventCommand(String input) {
        super(input);
    }

    /**
     * Builds an Event task from the user input.
     *
     * @return A new Event task
     * @throws KiweeException          If the input is empty
     * @throws KiweeCommandException   If required keywords "/from", "/to" or description are missing
     * @throws EndBeforeStartException If the end time is before the start time
     */
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

    /**
     * Indicates whether this command should exit the application.
     *
     * @return false, as adding an event does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
