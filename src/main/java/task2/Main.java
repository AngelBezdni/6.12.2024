package task2;

public class Main {
    public static void main(String[] args) {
        PersonDao dao = new PersonDao();

        // Добавление нового объекта
        Person person = new Person("Иван", 30);
        dao.save(person);
        System.out.println("Добавлен новый человек: " + person.getName());

        // Обновление существующего объекта
        person.setAge(35);
        dao.update(person);
        System.out.println("Обновленный возраст: " + person.getAge());

        // Получение объекта по ID
        Person foundPerson = dao.findById(person.getId());
        if (foundPerson != null) {
            System.out.println("Найденный человек: " + foundPerson.getName());
        }

        // Удаление объекта
        dao.delete(foundPerson);
        System.out.println("Человек удален.");
    }
}