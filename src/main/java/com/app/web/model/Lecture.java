package com.app.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lecture")
    private int idLecture;

    @Column(name = "jmeno")
    private String jmeno;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "pocet_testu")
    private int pocetTestu;

    public int getPocetTestu() {
        return pocetTestu;
    }

    public void setPocetTestu(int pocetTestu) {
        this.pocetTestu = pocetTestu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int id) {
        this.idLecture = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String url) {
        this.pictureUrl = url;
    }

}
