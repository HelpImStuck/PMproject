package com.example.zhukov.osbb;

public class Inhabitant {
    private String login;
    private String password;
    private String mail;
    private String name;
    private String lastname;
    private String gendr;


    public Inhabitant(String login, String password, String mail, String name, String lastname, String gendr) {
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.name = name;
        this.lastname = lastname;
        this.gendr = gendr;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGendr() {
        return gendr;
    }

    public void setGendr(String gendr) {
        this.gendr = gendr;
    }


    @Override
    public String toString() {
        return "Inhabitant{" +
                "login=" + login +
                ", firstName='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", Gender=" + gendr +
                '}';
    }


}
