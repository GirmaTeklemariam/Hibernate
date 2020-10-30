package edu.miu.com;

import edu.miu.com.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.com");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(new Person(123L, "Moges","Teklemariam",56));
        System.out.println(manager.createQuery("from Person"));
        System.out.println(manager.createNativeQuery("select * from Persontbl"));
        transaction.commit();

        manager.close();
    }
}
