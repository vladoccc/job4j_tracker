package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет быстро.");
    }

    @Override
    public void turn() {
        System.out.println(getClass().getSimpleName() + " поворачивает налево.");
    }
}
