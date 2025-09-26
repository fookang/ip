package Kiwee.task;

import Kiwee.utils.Dates;

import java.time.LocalDateTime;

/**
 * Represents an Event task.
 * An Event task has a description, completion status, start time and end time.
 */
public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Creates a new Event task with the specified description, start time and end time.
     * The task is initially marked as not done.
     *
     * @param description The description of the event task
     * @param from        The start time of the event task
     * @param to          The end time of the event task
     */
    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task.
     * The format is "[E]" followed by the status icon, description,
     * start time, and end time.
     *
     * @return A string in the format "[E][status] description (from: start_time to: end_time)"
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + Dates.formatDate(from) + " to: " + Dates.formatDate(to) + ")";
    }

    /**
     * Returns a String representation to be stored in data file.
     * The format is "E|completion_status|description|start_time|end_time"
     * where completion_status is "1" if done and "0" if not done.
     *
     * @return A string in the format "E|0|description|start_time|end_time" or "E|1|description|start_time|end_time"
     */
    @Override
    public String toStorageString() {
        return "E|" + (this.isDone ? "1|" : "0|") + this.description + "|" + this.from + "|" + this.to;
    }
}
