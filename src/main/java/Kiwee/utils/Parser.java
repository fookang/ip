package Kiwee.utils;

import Kiwee.exception.KiweeException;
import Kiwee.task.Deadline;
import Kiwee.task.Event;
import Kiwee.task.Task;
import Kiwee.task.Todo;

public class Parser {
    public static Task parseData(String line) throws KiweeException {
        String[] word = line.split("\\|");
        if (word.length < 3) {
            throw new KiweeException("Corrupted line");
        }
        switch (word[0].trim()) {
        case "T":
            Task todo = new Todo(word[2].trim());
            if (word[1].trim().equals("1")) {
                todo.markAsDone();
            }
            return todo;

        case "D":
            if (word.length != 4) {
                throw new KiweeException("Invalid line " + line);
            }
            Task deadline = new Deadline(word[2].trim(), word[3].trim());
            if (word[1].trim().equals("1")) {
                deadline.markAsDone();
            }
            return deadline;

        case "E":
            if (word.length != 5) {
                throw new KiweeException("Invalid event line " + line);
            }
            Task event = new Event(word[2].trim(), word[3].trim(), word[4].trim());
            if (word[1].trim().equals("1")) {
                event.markAsDone();
            }
            return event;

        default:
            throw new KiweeException("Invalid task type: " + word[0]);
        }
    }
}
