package edu.miu.com.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Persontbl")
public class Person {

    @Id
    private Long id;
    @Column(nullable = false, name = "First_Name")
    private String firstName;
    @Column(name="Last_Name", nullable = false)
    private String lastName;
    @Column(name="Age")
    private int age;
    @Column(name="Email", unique = true, length = 250, nullable = false)
    private String email;
    @Column(name="Create_Date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Transient
    private LocalDate birthDate;

    public Person(Long id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.createDate = new Date();
        this.birthDate = LocalDate.of(1956,02,23);
    }
}
