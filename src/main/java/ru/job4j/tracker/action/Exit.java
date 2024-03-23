package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.UserOutput;

public class Exit implements UserAction {

    private final UserOutput output;

    public Exit(UserOutput output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(UserInput input, Tracker tracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}
