package org.example;

import java.io.Serializable;

public class UserData implements Serializable {

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    private String name;

    private int age;

    public String getPassword() {
        return password;
    }

    private transient String password;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

//Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.

//Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person. Реализуйте методы для добавления, обновления и удаления объектов Person.