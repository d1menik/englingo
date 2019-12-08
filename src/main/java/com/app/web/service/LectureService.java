package com.app.web.service;

import com.app.web.model.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> findAll();

    void delete(Lecture lecture);

    Lecture getOne(Integer id);

    Lecture save(Lecture lecture);

}
