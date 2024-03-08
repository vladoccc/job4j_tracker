package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int people);

    int price(int fuel);
}
