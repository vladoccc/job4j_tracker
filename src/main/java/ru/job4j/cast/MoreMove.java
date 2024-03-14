package ru.job4j.cast;

public class MoreMove {

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] go = new Vehicle[]{airplane, train, bus};
        for (Vehicle object : go) {
            object.move();
            object.turn();
        }
    }
}
