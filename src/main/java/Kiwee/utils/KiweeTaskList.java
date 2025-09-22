package Kiwee.utils;

import Kiwee.task.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class KiweeTaskList implements Iterable<Task> {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public void add(Task t) {
        tasks.add(t);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int i) {
        return tasks.get(i);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public Task remove(int id) {
        return tasks.remove(id);
    }
}
