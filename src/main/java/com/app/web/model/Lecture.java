package com.app.web.model;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture")
    private Set<Test> tests;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String url) {
        this.pictureUrl = url;
    }

    private Set<Test> getTestsInternal() {
        if (this.tests == null) {
            this.tests = new HashSet<>();
        }
        return this.tests;
    }

    protected void setTestsInternal(Set<Test> tests) {
        this.tests = tests;
    }

    public List<Test> getTest() {
        List<Test> sortedTests = new ArrayList<>(getTestsInternal());
        PropertyComparator.sort(sortedTests, new MutableSortDefinition("title", false, false));
        return Collections.unmodifiableList(sortedTests);
    }

    public void addTest(Test test) {
        getTestsInternal().add(test);
        test.setLecture(this);
    }
}
