package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private Byte age;

    public User() {

    }
    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    public User(long id, String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User: ID = %d NAME = %-10s LAST_NAME = %-15s AGE = %d", id, name, lastName, age);
        //String.format("User: %-5s%-15s%-15s%-5s", id, name, lastName, age, "\n");
        //"User: ID = " + id + " NAME = " + name + " LAST_NAME " + lastName + " AGE " + age;
        //"User: id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "\n";

    }
}
