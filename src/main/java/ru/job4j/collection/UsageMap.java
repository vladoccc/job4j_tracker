package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> name = new HashMap<>();
        name.put("vladrma@gmail.com", "Vladislav Olegovich");
        for (String key : name.keySet()) {
            String value = name.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
