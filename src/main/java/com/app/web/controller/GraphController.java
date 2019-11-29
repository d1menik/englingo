package com.app.web.controller;

import com.app.web.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {

    @Autowired
    private GraphService graphService;

}
