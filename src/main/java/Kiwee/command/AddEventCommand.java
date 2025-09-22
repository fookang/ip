package Kiwee.command;

import Kiwee.exception.KiweeCommandException;
import Kiwee.task.Event;
import Kiwee.task.Task;

public class AddEventCommand extends AddCommand {
    public AddEventCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeCommandException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("input is empty");
        }
        String[] words = input.split("/from", 2);
        if (words.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }
        String description = words[0].trim();

        String time = words[1].trim();
        String[] details = time.split("/to", 2);

        if (details.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }

        String from = details[0].trim();
        String to = details[1].trim();

        return new Event(description, from, to);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
