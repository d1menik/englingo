package com.app.web.service;

import com.app.web.model.Graph;

import java.util.List;

public interface GraphService {

    List<Graph> findAll();

    void delete(Graph graph);

    Graph getOne(Integer id);

    Graph save(Graph graph);

}
