import java.util.Scanner;

public class Kiwee {
    private static final String PARTITION = "____________________________________________________________";

    private static final String LOGO = PARTITION + "\n"
            + " Hello! I'm Kiwee \uD83E\uDD5D \n"
            + " How can I help you?\n"
            + PARTITION;

    private static final String BYE_MESSAGE = PARTITION + "\n"
            + " Bye \uD83D\uDC4B Kiwee hope to see you again soon!\n"
            + PARTITION;

    private static final int CAPACITY = 100;

    private static void printTask(Task[] tasks, int size) {
        System.out.println(PARTITION);
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] "
                    + tasks[i].getDescription());
        }
        System.out.println(PARTITION);
    }

    public static void main(String[] args) {
        System.out.println(LOGO);

        Task[] tasks = new Task[CAPACITY];
        int size = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            String userInput = input.nextLine().trim();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(BYE_MESSAGE);
                break;

            } else if (userInput.equalsIgnoreCase("list")) {
                printTask(tasks, size);

            } else if (!userInput.isEmpty()) {
                // Split the input into command and action
                String[] words = userInput.split("\\s+", 2);
                String command = words[0].toLowerCase();
                String rest = words.length > 1 ? words[1] : "";

                switch (command) {
                case "mark":
                case "unmark":
                    Integer id = null;
                    try {
                        id = Integer.parseInt(rest);
                    } catch (NumberFormatException e) {
                        // let code fall through to default
                    }
                    if (id != null) {
                        if (id >= 1 && id <= size) {
                            if (command.equals("mark")) {
                                tasks[id - 1].markAsDone();
                                System.out.println(PARTITION);
                                System.out.println(" Well done! I have marked this as done!");
                                System.out.println("   [" + tasks[id - 1].getStatusIcon() + "] "
                                        + tasks[id - 1].getDescription());

                                System.out.println(PARTITION);
                            } else {
                                tasks[id - 1].markAsUndone();
                                System.out.println(PARTITION);
                                System.out.println(" OK, I've marked this as not done yet");
                                System.out.println("   [" + tasks[id - 1].getStatusIcon() + "] "
                                        + tasks[id - 1].getDescription());
                                System.out.println(PARTITION);
                            }
                        } else {
                            System.out.println(PARTITION);
                            System.out.println(" Invalid ID");
                            System.out.println(PARTITION);
                            break;
                        }
                        break;
                    }

                default:
                    if (size < CAPACITY) {
                        tasks[size++] = new Task(userInput);
                        System.out.println(PARTITION);
                        System.out.println(" Added: " + userInput);
                        System.out.println(PARTITION);
                    } else {
                        System.out.println(PARTITION);
                        System.out.println(" Capacity of 100 is reached");
                        System.out.println(PARTITION);
                    }
                    break;

                }


            }
            // else: ignore blank line
        }
    }
}
