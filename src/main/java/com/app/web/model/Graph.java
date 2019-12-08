package com.app.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Graph")
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_graph")
    private int idGraph;

    @Column(name = "uspesnost")
    private int uspesnost;

    public int getIdGraph() {
        return idGraph;
    }

    public void setIdGraph(int id) {
        this.idGraph = id;
    }

}
