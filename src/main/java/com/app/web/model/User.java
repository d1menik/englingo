package com.app.web.model;


import sun.security.util.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;

        return this;
    }
}
