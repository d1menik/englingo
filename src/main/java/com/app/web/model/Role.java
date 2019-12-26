package com.app.web.model;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role_type")
    private String roleType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> users;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public int getIdRole() {
        return id;
    }

    public void setIdRole(int id) {
        this.id = id;
    }

    private Set<User> getUsersInternal() {
        if (this.users == null) {
            this.users = new HashSet<>();
        }
        return this.users;
    }

    protected void setUsersInternal(Set<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        List<User> sortedUsers = new ArrayList<>(getUsersInternal());
        PropertyComparator.sort(sortedUsers, new MutableSortDefinition("created", false, false));
        return Collections.unmodifiableList(sortedUsers);
    }

    public void addUser(User user) {
        getUsersInternal().add(user);
        user.setRole(this);
    }
}
