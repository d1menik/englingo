package com.app.web.service;

import com.app.web.model.Test;

import java.util.List;

public interface TestService {

    List<Test> findAll();

    void delete(Test test);

    Test getOne(Integer id);

    Test save(Test test);

}
