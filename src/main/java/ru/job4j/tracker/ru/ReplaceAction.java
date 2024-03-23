package ru.job4j.tracker.ru;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askString("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
