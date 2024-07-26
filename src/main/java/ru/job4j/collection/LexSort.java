package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSrt = left.split("\\.");
        String[] rightStr = right.split("\\.");
        int one = Integer.parseInt(leftSrt[0]);
        int two = Integer.parseInt(rightStr[0]);
        return Integer.compare(one, two);
    }
}
