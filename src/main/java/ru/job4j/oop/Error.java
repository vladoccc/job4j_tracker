package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;

    }

    public void printInfo() {
        System.out.println("Ошибка: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Текст: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 404, "Error");
        Error error2 = new Error(true, 45, "Not value");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
    }
}
