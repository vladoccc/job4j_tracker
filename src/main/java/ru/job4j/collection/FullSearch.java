package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> numbers = new HashSet<>();
        for (Task number : tasks) {
            numbers.add(number.getNumber());
        }
        return numbers;
    }
}
