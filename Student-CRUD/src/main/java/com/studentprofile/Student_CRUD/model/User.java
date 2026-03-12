package com.studentprofile.Student_CRUD.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rollno;
    private String name;
    private String gender;

    private LocalDate dob;

    private String contactNo;
    private String email;

    public User() {}

    public User(String rollno, String name, String gender, LocalDate dob, String contactNo, String email) {
        this.rollno = rollno;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.contactNo = contactNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
