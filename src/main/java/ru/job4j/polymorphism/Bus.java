package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едем прямо");
    }

    @Override
    public void passengers(int people) {
        if (people == 10) {
            System.out.println("Все сидячие места заняты");
        } else {
            System.out.println("Места есть");
        }
    }

    @Override
    public int price(int fuel) {
        if (fuel == 100) {
            System.out.println("Полный бак");
        } else {
            System.out.println("В баке есть место");
        }
        return fuel;
    }
}
