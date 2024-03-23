package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.UserOutput;

public class Replace implements UserAction {

    private final UserOutput output;

    public Replace(UserOutput output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(UserInput input, Tracker tracker) {
        output.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askString("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Заявка изменена успешно.");
        } else {
            output.println("Ошибка замены заявки.");
        }
        return true;
    }
}
