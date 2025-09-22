package Kiwee.utils;

import Kiwee.exception.KiweeException;
import Kiwee.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Kiwee.utils.Parser.parseData;

public class DataManager {
    private final File dataFile;

    public DataManager(String filepath) {
        dataFile = new File(filepath);
    }

    public ArrayList<Task> loadTask() {
        ArrayList<Task> task = new ArrayList<>();
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

    private void saveTask(ArrayList<Task> tasks) throws IOException {
        try (FileWriter fw = new FileWriter(dataFile, false)) {
            for (Task task : tasks) {
                fw.write(task.toStorageString());
                fw.write(System.lineSeparator());
            }
        }
    }

    public void save(ArrayList<Task> tasks) {
        try {
            File parent = dataFile.getParentFile();

            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                System.err.println("Warning: Could not create directory " + parent.getAbsolutePath());
            }

            saveTask(tasks);

        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
