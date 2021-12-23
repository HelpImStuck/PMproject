package com.example.zhukov.osbb.core.org.condominiums.model;

//Клас мешканець
//описує мешканця ніякої логіки тут немає
public class Inhabitant {
    private long id;
    private String firstName;
    private String lastName;
    private boolean registration;
    private double balance;
    private int age;

    public Inhabitant() {
    }

    public Inhabitant(long id, String firstName, String lastName, boolean registration, double balance, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.balance = balance;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + " " + firstName + " " + lastName + " " + registration + " " + balance + " " + age;
    }
}
