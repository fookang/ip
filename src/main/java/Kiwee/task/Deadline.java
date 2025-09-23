package Kiwee.task;

import Kiwee.utils.Dates;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Dates.formatDate(this.by) + ")";
    }

    @Override
    public String toStorageString() {
        return "D|" + (this.isDone ? "1|" : "0|") + this.description + "|" + this.by;
    }
}
