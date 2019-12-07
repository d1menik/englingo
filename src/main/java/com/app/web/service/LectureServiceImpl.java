package com.app.web.service;

import com.app.web.model.Lecture;
import com.app.web.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> findAll(){
        return lectureRepository.findAll();
    }

    public void delete(Lecture lecture){
        lectureRepository.delete(lecture);
    }

    public Lecture getOne(Integer id){
        return lectureRepository.getOne(id);
    }

    public Lecture save(Lecture lecture){
        return lectureRepository.save(lecture);
    }

}
