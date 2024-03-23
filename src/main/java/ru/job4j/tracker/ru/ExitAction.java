package ru.job4j.tracker.ru;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitAction implements UserAction {

    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}
