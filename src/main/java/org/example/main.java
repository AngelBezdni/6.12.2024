import org.example.UserData;

import java.io.*;

public static void main(String[] args) throws IOException, ClassNotFoundException {

    UserData and = new UserData("1111", 1 , "11111111");
    UserData a = new UserData("22222", 2 , "2222222");

    try (FileOutputStream fileOutputStream = new FileOutputStream("uss.bin")) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(and);
            System.out.println("Объект UserData был сериализован. ");
        }
    }

    System.out.println(a.getName());
    System.out.println(a.getPassword());

    try (FileInputStream fileInputStream = new FileInputStream("uss.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            a = (UserData)objectInputStream.readObject();
        System.out.println("Объект UserData был десериализован. ");
    }

    System.out.println(a.getName());
    System.out.println(a.getPassword());
}
