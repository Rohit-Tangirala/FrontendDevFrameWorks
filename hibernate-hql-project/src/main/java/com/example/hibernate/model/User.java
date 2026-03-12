package com.example.hibernate.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "rollno")
    private int rollno;

    @Column(name = "name")
    private String name;

    public User() {}

    public User(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() { return rollno; }
    public void setRollno(int rollno) { this.rollno = rollno; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "User [rollno=" + rollno + ", name=" + name + "]";
    }
}
