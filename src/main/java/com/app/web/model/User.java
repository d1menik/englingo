package com.app.web.model;

import com.app.web.security.CustomUserDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "active")
    private boolean active;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Statistic> statistics;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIdUser() {
        return id;
    }

    public void setIdUser(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String name) {
        this.username = name;

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

    private Set<Statistic> getStatisticsInternal() {
        if (this.statistics == null) {
            this.statistics = new HashSet<>();
        }
        return this.statistics;
    }

    protected void setStatisticsInternal(Set<Statistic> statistics) {
        this.statistics = statistics;
    }

    public List<Statistic> getStatistics() {
        List<Statistic> sortedStatistics = new ArrayList<>(getStatisticsInternal());
        PropertyComparator.sort(sortedStatistics, new MutableSortDefinition("created", false, false));
        return Collections.unmodifiableList(sortedStatistics);
    }

    public void addStatistic(Statistic statistic) {
        getStatisticsInternal().add(statistic);
        statistic.setUser(this);
    }
}
