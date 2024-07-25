package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job name1, Job name2) {
        return name2.getName().compareTo(name1.getName());
    }
}
