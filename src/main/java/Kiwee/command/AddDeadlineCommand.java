package Kiwee.command;

import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Deadline;
import Kiwee.task.Task;
import Kiwee.utils.Dates;

import java.time.LocalDateTime;

/**
 * Command for adding a deadline task to the task list.
 */
public class AddDeadlineCommand extends AddCommand {
    /**
     * Creates a new AddDeadlineCommand with the specified user input.
     *
     * @param input The user input containing the deadline description and due date
     */
    public AddDeadlineCommand(String input) {
        super(input);
    }

    /**
     * Returns a Deadline task built from the user's input.
     * Parses the input to extract the description and due date, then creates a new Deadline task.
     *
     * @return A new Deadline task
     * @throws KiweeException        If the input is empty
     * @throws KiweeCommandException If required keyword "/by" is missing, description is empty, or due date is empty
     */
    @Override
    protected Task buildTask() throws KiweeException, KiweeCommandException {
        if (input.isEmpty()) {
            throw new KiweeException("That's not a deadline, that's silence. Say something!");
        }

        String[] words = input.split("/by", 2);
        if (words.length < 2) {
            throw new KiweeCommandException("Missing '/by' - deadlines need dates, not vibes.");
        }

        String description = words[0].trim();
        if (description.isEmpty()) {
            throw new KiweeCommandException("Describe the task, please. Kiwee can’t read minds (yet).");
        }

        String byStr = words[1].trim();
        if (byStr.isEmpty()) {
            throw new KiweeCommandException("When is it due? Stop procrastinating!!");
        }

        LocalDateTime by = Dates.parseDate(words[1].trim());
        return new Deadline(description, by);
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as adding a deadline does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
