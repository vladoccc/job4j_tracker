package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.UserOutput;

public class FindByName implements UserAction {

    private final UserOutput output;

    public FindByName(UserOutput output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(UserInput input, Tracker tracker) {
        output.println("=== Вывод заявок по имени ===");
        String name = input.askString("Введите имя: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с введенным именем: " + name + " не найдены.");
        }
        return true;
    }
}
