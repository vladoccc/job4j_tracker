package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит хоть куда.");

    }

    @Override
    public void turn() {
        System.out.println(getClass().getSimpleName() + " кружится в воздухе.");
    }
}
