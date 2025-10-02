package Kiwee.task;

/**
 * Abstract class that represents a task with a description and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a new Task with the specified description.
     * The task is initially marked as not done.
     *
     * @param description The description of the Task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return the completion status of the Tasks.
     *
     * @return "X" if done, " " if not
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Return the description of the Tasks.
     *
     * @return The description of this task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Marks this task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns whether this task is done.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Marks this task as not done.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string in the format "[status] description"
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    /**
     * Returns a string representation for storing the task in a file.
     * This is an abstract method that must be implemented by subclasses
     * to provide their specific storage format.
     *
     * @return A formatted string for file storage
     */
    public abstract String toStorageString();
}
