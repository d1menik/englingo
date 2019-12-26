package com.app.web.service;

import com.app.web.model.Statistic;

import java.util.List;

public interface StatisticService {

    List<Statistic> findAll();

    void delete(Statistic statistic);

    Statistic getOne(Integer id);

    Statistic save(Statistic statistic);

}
