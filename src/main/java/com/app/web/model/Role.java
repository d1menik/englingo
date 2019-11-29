package com.app.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private int idRole;

    @Column(name = "typ_role")
    private String typRole;

    public String getTypRole() {
        return typRole;
    }

    public void setTypRole(String typRole) {
        this.typRole = typRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int id) {
        this.idRole = id;
    }

}
