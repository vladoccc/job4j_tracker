package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {
    @Override
    public int compare(Job priority1, Job priority2) {
        return Integer.compare(priority1.getPriority(), priority2.getPriority());
    }
}
