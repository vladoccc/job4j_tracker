package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book one = new Book("Война и мир", 500);
        Book two = new Book("Колобок", 30);
        Book three = new Book("Java", 1000);
        Book four = new Book("Clean book", 10);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + "-" + book.getPage());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + "-" + book.getPage());
        }
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean book")) {
                System.out.println(book.getName() + "-" + book.getPage());
            }
        }
    }
}
