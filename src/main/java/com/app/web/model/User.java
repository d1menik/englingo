package com.app.web.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "jmeno")
    private String jmeno;

    @Column(name = "prijmeni")
    private String prijmeni;

    @Column(name = "vek")
    private int vek;

    @Column(name = "mail")
    private String email;

    @Column(name = "heslo")
    private String heslo;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int id) {
        this.idUser = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public User setJmeno(String name) {
        this.jmeno = name;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public User setHeslo(String password) {
        this.heslo = password;

        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public User setPrijmeni(String surname) {
        this.prijmeni = surname;

        return this;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

}
