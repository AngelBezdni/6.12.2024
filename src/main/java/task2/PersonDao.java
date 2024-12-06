package task2;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        entityManager = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    }

    public void save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    public void delete(Person person) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
        entityManager.getTransaction().commit();
    }
}