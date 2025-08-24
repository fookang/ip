import java.util.Scanner;

public class Kiwee {
    public static void main(String[] args) {
        final String PARTITION = "____________________________________________________________";

        final String LOGO = PARTITION + "\n"
                + " Hello! I'm Kiwee \uD83E\uDD5D \n"
                + " How can I help you?\n"
                + PARTITION;

        final String BYE_MESSAGE = PARTITION + "\n"
                + " Bye \uD83D\uDC4B Hope to see you again soon!\n"
                + PARTITION;

        Scanner input = new Scanner(System.in);
        System.out.println(LOGO);

        while (true) {
            String userInput = input.nextLine().trim();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(BYE_MESSAGE);
                break;
            } else if (!userInput.isEmpty()) {
                String result = PARTITION + "\n"
                        + " " + userInput + "\n"
                        + PARTITION;
                System.out.println(result);
            }
            // else: ignore blank line
        }
    }
}
