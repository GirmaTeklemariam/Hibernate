package edu.miu.cs;

import edu.miu.cs.domain.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        persist();
        update();
        find();
        getReference();
    }

    public static void persist(){
        System.out.println("Mapping data to database using persist API");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.cs");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        var p1 = new People("Feruz","Omure");
        manager.persist(p1);
        manager.getTransaction().commit();
        System.out.println(p1);
        manager.close();
        factory.close();
    }

    public static void update(){
        System.out.println("Update data to database using persist API and getter setter");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.cs");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        var p1 = new People("Feruz","Omure");
        System.out.println("1------------------------------");
        manager.persist(p1);
        System.out.println(p1);
        System.out.println("2------------------------------");
        p1.setFirstName("Messay");
        p1.setLastName("Emshaw");
        System.out.println("3-------------------------------");
        manager.getTransaction().commit();
        System.out.println(p1);
        System.out.println("4------------------------------");
        manager.close();
        factory.close();
    }

    public static void find(){
        System.out.println("Find data at database using find API ");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.cs");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        var p1 = new People("Feruz","Omure");
        manager.persist(p1);
        System.out.println(manager.find(People.class, 1L));
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public static void getReference(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.miu.cs");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        var p1 = new People("Girma", "Moges");
        manager.persist(p1);
        System.out.println(manager.getReference(People.class, 1L));
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
