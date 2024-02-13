package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int z) {
        return sum(z) + minus(z) + multiply(z) + divide(z);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        int result1 = minus(2);
        int result2 = calculator.multiply(3);
        int result3 = calculator.divide(30);
        int sumAll = calculator.sumAllOperation(10);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(sumAll);
    }
}
