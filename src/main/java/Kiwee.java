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
                System.out.println(PARTITION );
                for (int i = 0; i < size; i++) {
                    System.out.println(" " + (i+1) + ". " + tasks[i].getDescription());
                }
                System.out.println(PARTITION);

            } else if (!userInput.isEmpty()) {
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
            }
            // else: ignore blank line
        }
    }
}
