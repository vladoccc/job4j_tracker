package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String line : origin) {
            check.add(line);
        }
        for (String text1 : text) {
            if (!check.contains(text1)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
