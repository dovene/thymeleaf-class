package com.example.hellothym.model;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private int age;
    private String address;
    private String id;
    private String job;
    private LocalDate birthDate;
    private double salary;

    public Person() {
    }

    // add a constructor with all fields salary included
    public Person(String lastName, String firstName, int age, String address, String id, String job, LocalDate birthDate, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
        this.id = id;
        this.job = job;
        this.birthDate = birthDate;
        this.salary = salary;
    }


    // add all getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}