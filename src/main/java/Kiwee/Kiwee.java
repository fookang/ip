package Kiwee;

import Kiwee.command.Command;
import Kiwee.exception.KiweeException;
import Kiwee.utils.Parser;
import Kiwee.utils.Storage;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Ui;

/**
 * Main application class for the Kiwee task management system.
 */
public class Kiwee {

    private final static String FILEPATH = "./data/Kiwee.txt";
    private final Storage storage;
    private final KiweeTaskList tasks;
    private final Ui ui;

    /**
     * Creates a new Kiwee application instance.
     * 
     * @param filepath The file path for data storage
     */
    public Kiwee(String filepath) {
        // Load data or create new List
        storage = new Storage(FILEPATH);
        tasks = storage.loadTask();
        ui = new Ui();
    }

    /**
     * Starts the main application loop.
     */
    public void run() {
        Ui.WELCOME_MESSAGE();
        boolean isExit = false;
        while (!isExit) {
            String userInput = ui.readCommand();

            if (userInput.isEmpty()) {
                continue;
            }

            try {
                Command c = Parser.parseCommand(userInput, tasks);
                c.execute(tasks, storage);
                isExit = c.isExit();

            } catch (KiweeException e) {
                Ui.printMessage(e.getMessage());
            }
        }
    }

    /**
     * Main entry point for the Kiwee application.
     * 
     * @param args Command line arguments
     * @throws KiweeException If any method fails
     */
    public static void main(String[] args) throws KiweeException {
        new Kiwee(FILEPATH).run();
    }
}

