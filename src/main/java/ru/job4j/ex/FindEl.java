package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемента в массиве нет.");
        }
        return result;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] array = {"cat", "dog", "monkey"};
        try {
            indexOf(array, "snake");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
