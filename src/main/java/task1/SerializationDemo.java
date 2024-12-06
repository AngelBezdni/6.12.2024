package task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создание объекта Person
        Person person = new Person("Иван", 30);

        // Сериализация объекта в файл
        serialize(person, "person.ser");

        // Десериализация объекта из файла
        Person deserializedPerson = deserialize("person.ser");

        System.out.println("Имя: " + deserializedPerson.getName());
        System.out.println("Возраст: " + deserializedPerson.getAge());
    }

    // Метод для сериализации объекта в файл
    public static void serialize(Person person, String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(person);
        }
    }

    // Метод для десериализации объекта из файла
    public static Person deserialize(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Person) in.readObject();
        }
    }
}