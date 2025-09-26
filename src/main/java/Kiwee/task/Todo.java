package Kiwee.task;

/**
 * Represents a simple todo task.
 * A todo task has a description and can be marked as done or not done.
 */
public class Todo extends Task {

    /**
     * Creates a new Todo task with the specified description.
     * The task is initially marked as not done.
     *
     * @param description The description of the todo task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the todo task.
     * The format is "[T]" followed by the status icon and description.
     *
     * @return A string in the format "[T][status] description"
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a String representation to be stored in data file.
     * The format is "T|completion_status|description"
     * where completion_status is "1" if done and "0" if not done.
     *
     * @return A string in the format "T|0|description" or "T|1|description"
     */
    @Override
    public String toStorageString() {
        return "T|" + (this.isDone ? "1|" : "0|") + this.description;
    }
}
