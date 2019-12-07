package com.app.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_quiz")
    private int idQuiz;

    @Column(name = "spravna_odpoved")
    private String spravnaOdpoved;

    @Column(name = "spatna_odpoved_jedna")
    private String spatnaOdpovedJedna;

    @Column(name = "spatna_odpoved_dva")
    private String spatnaOdpovedDva;

    @Column(name = "spatna_odpoved_tri")
    private String spatnaOdpovedTri;

    public String getSpatnaOdpovedJedna() {
        return spatnaOdpovedJedna;
    }

    public void setSpatnaOdpovedJedna(String spatnaOdpovedJedna) {
        this.spatnaOdpovedJedna = spatnaOdpovedJedna;
    }

    public String getSpatnaOdpovedDva() {
        return spatnaOdpovedDva;
    }

    public void setSpatnaOdpovedDva(String spatnaOdpovedDva) {
        this.spatnaOdpovedDva = spatnaOdpovedDva;
    }

    public String getSpatnaOdpovedTri() {
        return spatnaOdpovedTri;
    }

    public void setSpatnaOdpovedTri(String spatnaOdpovedTri) {
        this.spatnaOdpovedTri = spatnaOdpovedTri;
    }

    public String getSpravnaOdpoved() {
        return spravnaOdpoved;
    }

    public void setSpravnaOdpoved(String spravnaOdpoved) {
        this.spravnaOdpoved = spravnaOdpoved;
    }


    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int id) {
        this.idQuiz = id;
    }

}
