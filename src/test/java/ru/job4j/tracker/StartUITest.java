package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Изменение заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню: " + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindAllAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + item + ln
                        + "Меню: " + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", (item.getName()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + item + ln
                        + "Меню: " + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + item + ln
                        + "Меню: " + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"8", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать 0-0" + ln
                        + "Меню: " + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}