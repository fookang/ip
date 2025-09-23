package Kiwee;

import Kiwee.command.Command;
import Kiwee.exception.KiweeException;
import Kiwee.utils.Parser;
import Kiwee.utils.Storage;
import Kiwee.utils.KiweeTaskList;
import Kiwee.utils.Ui;

public class Kiwee {

    private final static String FILEPATH = "./data/Kiwee.txt";
    private final Storage storage;
    private final KiweeTaskList tasks;
    private final Ui ui;

    public Kiwee(String filepath) {
        // Load data or create new List
        storage = new Storage(FILEPATH);
        tasks = storage.loadTask();
        ui = new Ui();
    }

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

    public static void main(String[] args) throws KiweeException {
        new Kiwee(FILEPATH).run();
    }
}

