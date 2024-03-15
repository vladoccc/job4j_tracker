package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = input.askInt("-пункт- ");
            if (select == 0) {
                System.out.println("=== Создание заявки ===");
                System.out.print("Введите: ");
                String name = input.askString("-имя- ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок.");
                }
            } else if (select == 2) {
                System.out.println("=== Изменение заявки ===");
                System.out.print("Введите: ");
                int id = input.askInt("-id- ");
                System.out.println("Введите: ");
                String name = input.askString("-имя- ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки.");
                }
            } else if (select == 3) {
                System.out.println("=== Удаление  заявки ===");
                System.out.print("Введите: ");
                int id = input.askInt("-id- ");
                Item item = tracker.findById(id);
                tracker.delete(id);
                System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
            } else if (select == 4) {
                System.out.println("=== Вывод заявки по id ===");
                System.out.print("Введите: ");
                int id = input.askInt("-id- ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: + " + id + " не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Вывод заявок по имени ===");
                System.out.print("Введите: ");
                String name = input.askString("-имя- ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с введенным именем: " + name + " не найдены.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку",
                "Показать все заявки",
                "Изменить заявку",
                "Удалить заявку",
                "Показать заявку по id",
                "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
        System.out.println();
    }
}
