package com.app.web.repository;

import com.app.web.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GraphRepository extends JpaRepository<Graph, Integer> {

}
