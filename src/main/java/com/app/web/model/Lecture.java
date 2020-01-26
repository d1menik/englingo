package com.app.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "picture_url")
    private String pictureUrl;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture", fetch = FetchType.EAGER)
    private Set<Statistic> statistics;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String url) {
        this.pictureUrl = url;
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

    public List<Statistic> getStatistic() {
        List<Statistic> sortedStatistics = new ArrayList<>(getStatisticsInternal());
        PropertyComparator.sort(sortedStatistics, new MutableSortDefinition("title", false, false));
        return Collections.unmodifiableList(sortedStatistics);
    }

    public void addStatistics(Statistic statistic) {
        getStatisticsInternal().add(statistic);
        statistic.setLecture(this);
    }
}
