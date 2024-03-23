package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.UserOutput;

public class FindAll implements UserAction {

    private final UserOutput output;

    public FindAll(UserOutput output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(UserInput input, Tracker tracker) {
        output.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}
