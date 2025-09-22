package Kiwee.command;

import Kiwee.exception.KiweeCommandException;
import Kiwee.task.Task;
import Kiwee.task.Todo;

public class AddTodoCommand extends AddCommand {
    public AddTodoCommand(String input) {
        super(input);
    }

    @Override
    protected Task buildTask() throws KiweeCommandException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("Input is empty");
        }
        return new Todo(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
