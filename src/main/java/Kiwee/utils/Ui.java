package Kiwee.utils;

import Kiwee.task.Task;

import java.util.Scanner;

public class Ui {

    public static final String SPACE = "    ";

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
            + SPACE + "Kiwee reporting for duty  \n"
            + SPACE + "How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + SPACE + "Bye \uD83D\uDC4B Kiwee hopes you’re leaving to actually finish your\n"
            + SPACE + "tasks, not procrastinate harder.\n"
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

    public static void printTask(String header, KiweeTaskList tasks) {
        printLine();
        if (header != null && !header.isEmpty()) {
            System.out.println(SPACE + header);
        }
        if (tasks.isEmpty()) {
            System.out.println("Wow… so productive. Zero tasks.");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(Ui.SPACE + (i + 1) + "." + tasks.get(i));
        }
        printLine();
    }

    public static void printTask(KiweeTaskList tasks) {
        printTask(null, tasks);
    }

    public static void printTaskAdded(Task task, int count) {
        printLine();
        System.out.println(SPACE + "Another one? Fine… I’ve added this task:");
        System.out.println(SPACE + "Added: " + task);
        System.out.println(SPACE + "Your list now has " + count + " tasks. Good luck surviving that.");
        printLine();
    }

    public static void printTaskMarked(Task task) {
        printLine();
        System.out.println(SPACE + "Congrats, you finally achieved something!");
        System.out.println(SPACE + task);
        printLine();
    }

    public static void printTaskUnmarked(Task task) {
        printLine();
        System.out.println(SPACE + "How did you manage to do reverse work??");
        System.out.println(SPACE + task);
        printLine();
    }

    public static void printTaskDeleted(Task task, int count) {
        printLine();
        System.out.println(SPACE + "Deleted. Because pretending it never existed totally helps productivity.");
        System.out.println(SPACE + task);
        System.out.println(SPACE + "You have " + count + " tasks in your list");
        printLine();
    }

    private static String COMMAND_MESSAGE() {
        return ("""
                Input valid command
                To add todo:       todo <description>
                To add deadline:   deadline <description> /by <when>
                To add event:      event <description> /from <start> /to <end>
                Mark / Unmark:     mark <id> | unmark <id>
                Other:             list | bye """.replaceAll("(?m)^", SPACE));
    }

    public static String getCommandMessage() {
        return COMMAND_MESSAGE();
    }
}
