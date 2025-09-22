package Kiwee.utils;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;

import java.util.Scanner;

public class Ui {

    private static final String SPACE = "    ";

    private static final String PARTITION = SPACE + "____________________________________________________________";

    private static final String KIWEELOGO = """
             _  __ ___ __        __ _____  _____ 
            | |/ /|_ _|\\ \\      / /| ____|| ____|
            | ' /  | |  \\ \\ /\\ / / |  _|  |  _|  
            | . \\  | |   \\ V  V /  | |___ | |___ 
            |_|\\_\\|___|   \\_/\\_/   |_____| |_____|
            
            """.replaceAll("(?m)^", SPACE);

    private static final String LOGO = PARTITION + "\n"
            + KIWEELOGO
            + SPACE + "Hello! I'm Kiwee \n"
            + SPACE + "How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + SPACE + "Bye \uD83D\uDC4B Kiwee.Kiwee hope to see you again soon!\n"
            + PARTITION;

    public static void WELCOME_MESSAGE() {
        System.out.println(LOGO);
    }

    public static void BYE_MESSAGE() {
        System.out.println(BYE_MESSAGE);
    }

    private static void printLine() {
        System.out.println(PARTITION);
    }

    public static void printMessage(String string) {
        printLine();
        System.out.println(SPACE + string);
        printLine();
    }

    public String readCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }

    public static void printTask(KiweeTaskList tasks) throws KiweeException {
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("Your list is empty. Add tasks with: todo | deadline | event");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(Ui.SPACE + (i + 1) + "." + tasks.get(i));
        }
        printLine();
    }

    public static void printTaskAdded(Task task, int count) {
        printLine();
        System.out.println(SPACE + "Added: " + task);
        System.out.println(SPACE + "You have " + count + " tasks in your list");
        printLine();
    }

    public static void printTaskMarked(Task task) {
        printLine();
        System.out.println(SPACE + "Well done! I have marked this as done!");
        System.out.println(SPACE + task);
        printLine();
    }

    public static void printTaskUnmarked(Task task) {
        printLine();
        System.out.println(SPACE + "OK, I've marked this as not done yet");
        System.out.println(SPACE + task);
        printLine();
    }

    public static void printTaskDeleted(Task task, int count) {
        printLine();
        System.out.println(SPACE + "OK. I have deleted this task: \n " + task);
        System.out.println(SPACE + "You have " + count + " tasks in your list");
        printLine();
    }

    private static void printCommand() {
        System.out.print("""
                Input valid command
                To add todo:       todo <description>
                To add deadline:   deadline <description> /by <when>
                To add event:      event <description> /from <start> /to <end>
                Mark / Unmark:     mark <id> | unmark <id>
                Other:             list | bye
                """.replaceAll("(?m)^", SPACE));
    }

    public static void printCommandError(String message) {
        printLine();
        System.out.println(SPACE + message);
        printCommand();
        printLine();
    }
}
