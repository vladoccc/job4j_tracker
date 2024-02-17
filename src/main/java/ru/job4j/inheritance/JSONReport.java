package ru.job4j.inheritance;

import java.util.SplittableRandom;

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return
                "{" + System.lineSeparator()
                        + "\t\"name\" : \"name\"," + System.lineSeparator()
                        + "\t\"body\" : \"body\"" + System.lineSeparator()
                        + "}";
    }
}
