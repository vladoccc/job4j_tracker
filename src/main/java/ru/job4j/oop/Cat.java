package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("Имя котика:");
        Cat murzik = new Cat();
        murzik.giveNick("murzik");
        murzik.eat("milk");
        murzik.show();
    }
}
