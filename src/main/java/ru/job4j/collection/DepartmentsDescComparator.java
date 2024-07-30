package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split("/");
        String[] rightStr = right.split("/");
        if ((rightStr[0]).equals(leftStr[0])) {
            return left.compareTo(right);
        } else {
            return rightStr[0].compareTo(leftStr[0]);
        }
    }
}
