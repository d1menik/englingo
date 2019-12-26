package com.app.web.model;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.EAGER)
    private Set<Statistic> statistics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected Set<Statistic> getStatisticsInternal() {
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
        statistic.setTest(this);
    }
}
