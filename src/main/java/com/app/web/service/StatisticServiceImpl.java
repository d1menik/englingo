package com.app.web.service;

import com.app.web.model.Statistic;
import com.app.web.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public List<Statistic> findAll(){
        return statisticRepository.findAll();
    }

    public void delete(Statistic statistic){
        statisticRepository.delete(statistic);
    }

    public Statistic getOne(Integer id){
        return statisticRepository.getOne(id);
    }

    public Statistic save(Statistic statistic){
        return statisticRepository.save(statistic);
    }

}
