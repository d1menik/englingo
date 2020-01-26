package com.app.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "statistics")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "success_rate")
    private int successRate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate date) {
        this.created = date;
    }

    public void setSuccessRate(int rate) {
        this.successRate = rate;
    }

    public int getSuccessRate() {
        return this.successRate;
    }

}
