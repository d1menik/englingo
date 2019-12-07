package com.app.web.service;

import com.app.web.model.Graph;
import com.app.web.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphServiceImpl implements GraphService {

    @Autowired
    private GraphRepository graphRepository;

    public List<Graph> findAll(){
        return graphRepository.findAll();
    }

    public void delete(Graph graph){
        graphRepository.delete(graph);
    }

    public Graph getOne(Integer id){
        return graphRepository.getOne(id);
    }

    public Graph save(Graph graph){
        return graphRepository.save(graph);
    }

}
