package Kiwee.task;

import Kiwee.utils.Dates;

import java.time.LocalDateTime;

/**
 * Represents a Deadline task.
 * A Deadline task has a description, completion status and due date.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Creates a new Deadline task with the specified description and due date.
     * The task is initially marked as not done.
     *
     * @param description The description of the deadline task
     * @param by          The due date of the deadline task
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string representation of the deadline task.
     * The format is "[D]" followed by the status icon, description and due date.
     *
     * @return A string in the format "[D][status] description (by: due_date)"
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Dates.formatDate(this.by) + ")";
    }

    /**
     * Returns a String representation to be stored in data file.
     * The format is "D|completion_status|description|due_date"
     * where completion_status is "1" if done and "0" if not done.
     *
     * @return A string in the format "D|0|description|due_date" or "D|1|description|due_date"
     */
    @Override
    public String toStorageString() {
        return "D|" + (this.isDone ? "1|" : "0|") + this.description + "|" + this.by;
    }
}
