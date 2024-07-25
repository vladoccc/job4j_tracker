package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job priority1, Job priority2) {
        return Integer.compare(priority2.getPriority(), priority1.getPriority());
    }
}
