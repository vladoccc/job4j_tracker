package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.UserOutput;

public class Create implements UserAction {

    private final UserOutput output;

    public Create(UserOutput output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Добавить новую заявку";
    }

    @Override
    public boolean execute(UserInput input, Tracker tracker) {
        output.println("=== Создание заявки ===");
        String name = input.askString("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return true;
    }
}
