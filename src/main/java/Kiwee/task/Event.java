package Kiwee.task;

import Kiwee.utils.Dates;

import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + Dates.formatDate(from) + " to: " + Dates.formatDate(to) + ")";
    }

    @Override
    public String toStorageString() {
        return "E|" + (this.isDone ? "1|" : "0|") + this.description + "|" + this.from + "|" + this.to;
    }
}
