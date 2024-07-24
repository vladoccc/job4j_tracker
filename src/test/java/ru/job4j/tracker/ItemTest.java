package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Dn"),
                new Item("Cn"),
                new Item("Bn"),
                new Item("An")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("An"),
                new Item("Bn"),
                new Item("Cn"),
                new Item("Dn")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Ab"),
                new Item("Bb"),
                new Item("Cb"),
                new Item("Db")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Db"),
                new Item("Cb"),
                new Item("Bb"),
                new Item("Ab")
        );
        assertThat(items).isEqualTo(expected);
    }
}