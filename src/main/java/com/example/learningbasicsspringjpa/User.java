package com.example.learningbasicsspringjpa;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This JPA annotation tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
    @Id
    // @GeneratedValue(strategy= GenerationType.AUTO) // Hibernate will look for the default hibernate_sequence table
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String username;
    private int age;
    private String city;
   @CreationTimestamp
   @Column(name = "timestamp", nullable = false, updatable = false, insertable = false)
    // https://vladmihalcea.com/date-timestamp-jpa-hibernate/
    // Mapping column "timestamp" from MySQL DB to the "Timestamp timestamp" variable.
    // https://stackoverflow.com/questions/811845/setting-a-jpa-timestamp-column-to-be-generated-by-the-database
    private Timestamp timestamp;

    public User(String username, int age, String city) {
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public User() {

    }

    public void setId(int id) {
        this.id = id;
    }

    //@Id
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //@CreationTimestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
