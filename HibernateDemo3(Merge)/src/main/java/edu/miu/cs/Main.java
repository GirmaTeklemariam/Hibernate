package edu.miu.cs;

import edu.miu.cs.domian.Book;
import edu.miu.cs.domian.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.cs");

    public static void main(String[] args) {

        //Merge();
        MergeVsPersist();

    }

    public static void Merge(){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        var p1 = new Person("Feruz", "Oumer");
        manager.persist(p1);
        manager.detach(p1);

        var p2 = manager.find(Person.class, 1L);
        p1.setFirstName("Girma");

        p1 = manager.merge(p1);

        p1.setLastName("Moges");

        manager.getTransaction().commit();
        manager.close();
    }

    public static void MergeVsPersist(){
        System.out.println("=====================================================================");
        System.out.println("Difference between Merge and Persist");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        var book1 = new Book("111-222-333", "Hibernate");
        manager.merge(book1);
        var book2 = new Book("111-222-333", "Spring");
        manager.merge(book2);

        manager.getTransaction().commit();
        manager.close();
    }
}
