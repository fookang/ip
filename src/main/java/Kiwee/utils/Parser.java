package Kiwee.utils;

import Kiwee.command.AddDeadlineCommand;
import Kiwee.command.AddEventCommand;
import Kiwee.command.AddTodoCommand;
import Kiwee.command.ByeCommand;
import Kiwee.command.Command;
import Kiwee.command.DeleteCommand;
import Kiwee.command.ListCommand;
import Kiwee.command.MarkCommand;
import Kiwee.command.UnmarkCommand;
import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Deadline;
import Kiwee.task.Event;
import Kiwee.task.Task;
import Kiwee.task.Todo;

import java.time.LocalDateTime;

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
            LocalDateTime time = Dates.parseDate(word[3].trim());
            Task deadline = new Deadline(word[2].trim(), time);
            if (word[1].trim().equals("1")) {
                deadline.markAsDone();
            }
            return deadline;

        case "E":
            if (word.length != 5) {
                throw new KiweeException("Invalid event line " + line);
            }
            LocalDateTime from = Dates.parseDate(word[3].trim());
            LocalDateTime to = Dates.parseDate(word[4].trim());
            Task event = new Event(word[2].trim(), from, to);
            if (word[1].trim().equals("1")) {
                event.markAsDone();
            }
            return event;

        default:
            throw new KiweeException("Invalid task type: " + word[0]);
        }
    }

    private static int getId(String variable, KiweeTaskList tasks) throws KiweeException {
        int id;
        try {
            id = Integer.parseInt(variable);
        } catch (NumberFormatException e) {
            throw new KiweeException("Invalid ID");
        }

        if (id < 1 || id > tasks.size()) {
            throw new KiweeException("Invalid ID");
        }
        return id;
    }

    public static Command parseCommand(String userInput, KiweeTaskList tasks) throws KiweeException {
        String[] words = userInput.split("\\s+", 2);
        String command = words[0].toLowerCase();
        String rest = words.length > 1 ? words[1] : "";

        return switch (command) {
            case "bye" -> new ByeCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(getId(rest, tasks));
            case "unmark" -> new UnmarkCommand(getId(rest, tasks));
            case "todo" -> new AddTodoCommand(rest);
            case "deadline" -> new AddDeadlineCommand(rest);
            case "event" -> new AddEventCommand(rest);
            case "delete" -> new DeleteCommand(getId(rest, tasks));
            default -> throw new KiweeCommandException(command + " is not a valid command");
        };
    }
}
