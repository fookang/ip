package Kiwee.utils;

import Kiwee.task.Task;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A list for managing tasks in the Kiwee application.
 */
public class KiweeTaskList implements Iterable<Task> {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Adds a task to the list.
     *
     * @param t The task to add
     */
    public void add(Task t) {
        tasks.add(t);
    }

    /**
     * Returns whether the task list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the task at the specified index.
     *
     * @param i The index of the task to get
     * @return The task at the specified index
     */
    public Task get(int i) {
        return tasks.get(i);
    }

    /**
     * Returns an iterator for the tasks in this list.
     *
     * @return An iterator over the tasks
     */
    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    /**
     * Returns and removes the task at the specified index.
     *
     * @param id The index of the task to remove
     * @return The removed task
     */
    public Task remove(int id) {
        return tasks.remove(id);
    }
}
