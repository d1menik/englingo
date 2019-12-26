package com.app.web.service;

import com.app.web.model.Test;
import com.app.web.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public void delete(Test test){
        testRepository.delete(test);
    }

    public Test getOne(Integer id){
        return testRepository.getOne(id);
    }

    public Test save(Test test){
        return testRepository.save(test);
    }

}
