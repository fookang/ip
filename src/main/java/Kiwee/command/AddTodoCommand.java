package Kiwee.command;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;
import Kiwee.task.Todo;

/**
 * Command for adding an event task to the task list.
 */
public class AddTodoCommand extends AddCommand {

    /**
     * Creates a new AddTodoCommand with the specified user input.
     *
     * @param input The user input containing the todo description
     */
    public AddTodoCommand(String input) {
        super(input);
    }

    /**
     * Returns a Todo task built from the user's input.
     *
     * @return A new Todo task
     * @throws KiweeException If the input is empty
     */
    @Override
    protected Task buildTask() throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeException("That's not a task, that's silence. Say something!");
        }
        return new Todo(input);
    }

    /**
     * Returns whether this command should exit the application.
     *
     * @return false, as adding a todo does not exit the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
