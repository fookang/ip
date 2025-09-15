package Kiwee;

import Kiwee.exception.KiweeCommandException;
import Kiwee.exception.KiweeException;
import Kiwee.task.Deadline;
import Kiwee.task.Event;
import Kiwee.task.Task;
import Kiwee.task.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiwee {

    private static final ArrayList<Task> tasks = new ArrayList<>();

    private static final String PARTITION = "____________________________________________________________";

    private static void printLine() {
        System.out.println(PARTITION);
    }

    private static final String LOGO = PARTITION + "\n"
            + " Hello! I'm Kiwee.Kiwee \uD83E\uDD5D \n"
            + " How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + " Bye \uD83D\uDC4B Kiwee.Kiwee hope to see you again soon!\n"
            + PARTITION;

    private static void printTask() throws KiweeException {
        printLine();
        if (tasks.isEmpty()) {
            System.out.println(" Your list is empty. Add tasks with: todo | deadline | event");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i));
        }
        printLine();
    }

    private static void printAddMessage(Task task) {
        printLine();
        System.out.println(" Added: " + task);
        System.out.println("You have " + tasks.size() + " tasks in your list");
        printLine();
    }

    private static void handleCompletionCommand(String command, String variable) throws KiweeException {
        int id = getId(variable);

        if (command.equals("mark")) {
            tasks.get(id - 1).markAsDone();
            printLine();
            System.out.println(" Well done! I have marked this as done!");
        } else {
            tasks.get(id - 1).markAsUndone();
            printLine();
            System.out.println(" OK, I've marked this as not done yet");
        }

        System.out.println(tasks.get(id - 1));
        printLine();
    }

    private static void addTodo(String description) throws KiweeException {
        if (description.isEmpty()) {
            throw new KiweeCommandException("Input is empty");
        }
        Todo todo = new Todo(description);
        tasks.add(todo);
        printAddMessage(todo);
    }

    private static void addDeadline(String input) throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("input is empty");
        }
        String[] words = input.split("/by", 2);
        if (words.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }
        String description = words[0].trim();
        String by = words[1].trim();

        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        printAddMessage(deadline);
    }

    private static void addEvent(String input) throws KiweeException {
        if (input.isEmpty()) {
            throw new KiweeCommandException("input is empty");
        }
        String[] words = input.split("/from", 2);
        if (words.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }
        String description = words[0].trim();

        String time = words[1].trim();
        String[] details = time.split("/to", 2);

        if (details.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }

        String from = details[0].trim();
        String to = details[1].trim();

        Event event = new Event(description, from, to);
        tasks.add(event);
        printAddMessage(event);
    }

    private static void deleteTask(String variable) throws KiweeException {
        int id = getId(variable);
        Task remove = tasks.remove(id - 1);
        printLine();
        System.out.println("OK. I have deleted this task: \n " + remove);
        System.out.println("You have " + tasks.size() + " tasks in your list");
        printLine();
    }

    private static int getId(String variable) throws KiweeException {
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

    private static void printError() {
        System.out.print("""
                 Input valid command
                 To add todo:       todo <description>
                 To add deadline:   deadline <description> /by <when>
                 To add event:      event <description> /from <start> /to <end>
                 Mark / Unmark:     mark <id> | unmark <id>
                 Other:             list | bye
                """);
    }

    public static void main(String[] args) {
        System.out.println(LOGO);

        Scanner input = new Scanner(System.in);

        while (true) {
            String userInput = input.nextLine().trim();

            if (userInput.isEmpty()) {
                continue;
            }

            // Split the input into command and action
            String[] words = userInput.split("\\s+", 2);
            String command = words[0].toLowerCase();
            String rest = words.length > 1 ? words[1] : "";
            try {
                switch (command) {
                case "bye":
                    System.out.println(BYE_MESSAGE);
                    return;

                case "list":
                    printTask();
                    break;

                case "mark":
                case "unmark":
                    handleCompletionCommand(command, rest);
                    break;

                case "todo":
                    addTodo(rest);
                    break;

                case "deadline":
                    addDeadline(rest);
                    break;

                case "event":
                    addEvent(rest);
                    break;

                case "delete":
                    deleteTask(rest);
                    break;

                default:
                    throw new KiweeCommandException(command + " is not a valid command");
                }
            } catch (KiweeCommandException e) {
                printLine();
                System.out.println(" " + e.getMessage());
                printError();
                printLine();
            } catch (KiweeException e) {
                printLine();
                System.out.println(" " + e.getMessage());
                printLine();
            }
        }
    }
}

