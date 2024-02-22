package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsName = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(items[i].getName())) {
                itemsName[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(itemsName, count);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}