import java.util.Scanner;

public class Kiwee {
    private static final int CAPACITY = 100;

    private static final Task[] tasks = new Task[CAPACITY];

    private static int size = 0;

    private static final String PARTITION = "____________________________________________________________";

    private static final String LOGO = PARTITION + "\n"
            + " Hello! I'm Kiwee \uD83E\uDD5D \n"
            + " How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + " Bye \uD83D\uDC4B Kiwee hope to see you again soon!\n"
            + PARTITION;

    private static void printTask() {
        System.out.println(PARTITION);
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + "." + tasks[i].toString());
        }
        System.out.println(PARTITION);
    }

    private static void printAddMessage(Task task) {
        System.out.println(PARTITION);
        System.out.println(" Added: " + task.toString());
        System.out.println("You have " + size + " tasks in your list");
        System.out.println(PARTITION);
    }

    private static void handleCompletionCommand(String command, String variable) throws KiweeException {
        int id;
        try {
            id = Integer.parseInt(variable);
        } catch (NumberFormatException e) {
            throw new KiweeException("Invalid ID");
        }

        if (id < 1 || id > size) {
            throw new KiweeException("Invalid ID");
        }

        if (command.equals("mark")) {
            tasks[id - 1].markAsDone();
            System.out.println(PARTITION);
            System.out.println(" Well done! I have marked this as done!");
        } else {
            tasks[id - 1].markAsUndone();
            System.out.println(PARTITION);
            System.out.println(" OK, I've marked this as not done yet");
        }

        System.out.println(tasks[id - 1].toString());
        System.out.println(PARTITION);
    }

    private static void addTodo(String description) throws KiweeException {
        if (size < CAPACITY) {
            tasks[size++] = new Todo(description);
            printAddMessage(tasks[size - 1]);
        } else {
            throw new KiweeException("Capacity of 100 is reached");
        }
    }

    private static void addDeadline(String input) throws KiweeException {
        String[] words = input.split("/by", 2);
        if (words.length <= 1) {
            throw new KiweeCommandException("Invalid command");
        }
        String description = words[0].trim();
        String by = words[1].trim();
        if (size < CAPACITY) {
            tasks[size++] = new Deadline(description, by);
            printAddMessage(tasks[size - 1]);
        } else {
            throw new KiweeException("Capacity of 100 is reached");
        }
    }

    private static void addEvent(String input) throws KiweeException {
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

        if (size < CAPACITY) {
            tasks[size++] = new Event(description, from, to);
            printAddMessage(tasks[size - 1]);
        } else {
            throw new KiweeException("Capacity of 100 is reached");
        }
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

                default:
                    throw new KiweeCommandException(command + " is not a valid command");
                }
            } catch (KiweeCommandException e) {
                System.out.println(PARTITION);
                System.out.println(" " + e.getMessage());
                printError();
                System.out.println(PARTITION);
            } catch (KiweeException e) {
                System.out.println(PARTITION);
                System.out.println(" " + e.getMessage());
                System.out.println(PARTITION);
            }
        }
    }
}

