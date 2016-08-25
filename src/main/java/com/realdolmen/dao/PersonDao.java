package com.realdolmen.dao;

import com.realdolmen.servlets.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonDao {
    private EntityManager entityManager;

    private static PersonDao instance;

    /**
     * Singleton
     */
    public static PersonDao getInstance() {
        if(instance == null) {
            instance = new PersonDao();
        }
        return instance;
    }

    private PersonDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p").getResultList();
    }

    public void save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public void remove(int id){
        entityManager.getTransaction().begin();
        Person p = entityManager.getReference(Person.class, id);
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }
}
