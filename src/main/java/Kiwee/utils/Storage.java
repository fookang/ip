package Kiwee.utils;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Kiwee.utils.Parser.parseData;

/**
 * Handles loading and saving tasks to a data file.
 */
public class Storage {
    private final File dataFile;

    /**
     * Creates a new Storage instance with the specified file path.
     *
     * @param filepath The path to the data file
     */
    public Storage(String filepath) {
        dataFile = new File(filepath);
    }

    /**
     * Loads tasks from the data file into a task list.
     *
     * @return A KiweeTaskList containing all valid tasks from the file
     */
    public KiweeTaskList loadTask() {
        KiweeTaskList task = new KiweeTaskList();
        try (Scanner s = new Scanner(dataFile)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                try {
                    Task parsed = parseData(line);
                    task.add(parsed);
                } catch (KiweeException e) {
                    System.err.println("Skipping corrupt line " + line);
                }

            }
        } catch (FileNotFoundException e) {
            return task;
        }
        return task;
    }

    /**
     * Saves the task list to the data file.
     *
     * @param tasks The task list to save
     * @throws IOException If writing to the file fails
     */
    private void saveTask(KiweeTaskList tasks) throws IOException {
        try (FileWriter fw = new FileWriter(dataFile, false)) {
            for (Task task : tasks) {
                fw.write(task.toStorageString());
                fw.write(System.lineSeparator());
            }
        }
    }

    /**
     * Saves the task list to the data file.
     *
     * @param tasks The task list to save
     */
    public void save(KiweeTaskList tasks) {
        try {
            File parent = dataFile.getParentFile();

            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                System.err.println("Warning: Could not create directory " + parent.getAbsolutePath());
                return;
            }

            saveTask(tasks);

        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
