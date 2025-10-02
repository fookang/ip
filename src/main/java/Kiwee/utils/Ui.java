package Kiwee.utils;

import Kiwee.task.Task;

import java.util.Scanner;

/**
 * Handles all user interface operations for the Kiwee application.
 */
public class Ui {

    private static final Scanner INPUT_SCANNER = new Scanner(System.in);

    public static final String SPACE = "    ";

    private static final String PARTITION = SPACE
            + "____________________________________________________________";

    private static final String KIWEELOGO = """
             _  __ ___ __        __ _____  _____ 
            | |/ /|_ _|\\ \\      / /| ____|| ____|
            | ' /  | |  \\ \\ /\\ / / |  _|  |  _|  
            | . \\  | |   \\ V  V /  | |___ | |___ 
            |_|\\_\\|___|   \\_/\\_/   |_____| |_____|
            
            """.replaceAll("(?m)^", SPACE);

    private static final String LOGO = PARTITION + "\n"
            + KIWEELOGO
            + SPACE + "Kiwee reporting for duty  \n"
            + SPACE + "How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + SPACE + "Bye! Kiwee hopes you're leaving to actually finish your\n"
            + SPACE + "tasks, not procrastinate harder.\n"
            + PARTITION;

    /**
     * Prints the welcome message when application starts.
     */
    public static void WELCOME_MESSAGE() {
        System.out.println(LOGO);
    }

    /**
     * Prints the farewell message when application ends.
     */
    public static void BYE_MESSAGE() {
        System.out.println(BYE_MESSAGE);
    }

    /**
     * Prints a partition line for visual separation.
     */
    private static void printLine() {
        System.out.println(PARTITION);
    }

    /**
     * Prints a message with partition lines for formatting.
     *
     * @param string The message to be displayed
     */
    public static void printMessage(String string) {
        printLine();
        System.out.println(SPACE + string);
        printLine();
    }

    /**
     * Returns the user's command.
     *
     * @return The trimmed user input command
     */
    public String readCommand() {
        return INPUT_SCANNER.nextLine().trim();
    }

    /**
     * Prints the list of tasks with an optional header.
     *
     * @param header Header message to display above the task list
     * @param tasks  The task list containing all the tasks
     */
    public static void printTask(String header, KiweeTaskList tasks) {
        printLine();
        if (header != null && !header.isEmpty()) {
            System.out.println(SPACE + header);
        }
        if (tasks.isEmpty()) {
            System.out.println(Ui.SPACE + "Wow... so productive. Zero tasks.");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(Ui.SPACE + (i + 1) + "." + tasks.get(i));
        }
        printLine();
    }

    /**
     * Prints the list of tasks without a header.
     *
     * @param tasks The task list containing all the tasks
     */
    public static void printTask(KiweeTaskList tasks) {
        printTask(null, tasks);
    }

    /**
     * Prints a success message when a task is added to the task list.
     *
     * @param task  The task that was added
     * @param count The number of tasks in the task list after adding
     */
    public static void printTaskAdded(Task task, int count) {
        printLine();
        System.out.println(SPACE + "Another one? Fine... I've added this task:");
        System.out.println(SPACE + "Added: " + task);
        System.out.println(SPACE + "Your list now has "
                + count + " tasks. Good luck surviving that.");
        printLine();
    }

    /**
     * Prints a success message when a task is marked as done.
     *
     * @param task The task that was marked as done
     */
    public static void printTaskMarked(Task task) {
        printLine();
        System.out.println(SPACE + "Congrats, you finally achieved something!");
        System.out.println(SPACE + task);
        printLine();
    }

    /**
     * Prints a message when a task is marked as not done.
     *
     * @param task The task that marked as not done
     */
    public static void printTaskUnmarked(Task task) {
        printLine();
        System.out.println(SPACE + "How did you manage to do reverse work??");
        System.out.println(SPACE + task);
        printLine();
    }

    /**
     * Prints a success message when a task is deleted.
     *
     * @param task  The task that was deleted
     * @param count The number of tasks remaining in the task list
     */
    public static void printTaskDeleted(Task task, int count) {
        printLine();
        System.out.println(SPACE + "Deleted. "
                + "Because pretending it never existed totally helps productivity.");
        System.out.println(SPACE + task);
        System.out.println(SPACE + "You have " + count + " tasks in your list");
        printLine();
    }

    /**
     * Returns the list of available commands for user reference.
     *
     * @return A formatted string containing all available commands
     */
    private static String COMMAND_MESSAGE() {
        return ("""
                Input valid command
                To add todo:       todo <description>
                To add deadline:   deadline <description> /by <when>
                To add event:      event <description> /from <start> /to <end>
                Mark / Unmark:     mark <id> | unmark <id>
                Other:             list | bye""".replaceAll("(?m)^", SPACE));
    }

    /**
     * Returns the formatted command help message.
     *
     * @return A string containing all available commands and their usage
     */
    public static String getCommandMessage() {
        return COMMAND_MESSAGE();
    }
}
