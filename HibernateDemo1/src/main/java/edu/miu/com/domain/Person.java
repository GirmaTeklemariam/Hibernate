package edu.miu.com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Persontbl")
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
