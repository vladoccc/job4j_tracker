package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> name = new HashMap<>();
        name.put("vladrma@gmail.com", "Vladislav Olegovich");
        name.put("igors@gmail.com", "Igor Sergeevich");
        name.put("sobaka@gmail.com", "Ivan Ivanovich");
        name.put("sobaka@gmail.com", "Ivan Petrovich");
        name.put("sergey@gmail.com", "Sergey Petrovich");
        for (String key : name.keySet()) {
            String value = name.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
