package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Максимов Максим Максимович");
        student.setGroup("ЭММА-21");
        student.setArrival(new Date());
        System.out.println(student.getName() + " учится в группе " + student.getGroup() + " c " + student.getArrival());
    }
}
