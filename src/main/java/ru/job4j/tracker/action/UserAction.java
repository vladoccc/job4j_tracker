package ru.job4j.tracker.action;

import ru.job4j.tracker.input.UserInput;
import ru.job4j.tracker.Tracker;

public interface UserAction {

    String name();

    boolean execute(UserInput input, Tracker tracker);
}
