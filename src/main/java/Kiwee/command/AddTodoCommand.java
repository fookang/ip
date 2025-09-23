package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;
import Kiwee.task.Todo;

public class AddTodoCommand extends AddCommand {
    public AddTodoCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeException("That’s not a task, that’s silence. Say something!");
        }
        return new Todo(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
