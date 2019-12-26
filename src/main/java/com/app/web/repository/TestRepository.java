package com.app.web.repository;

import com.app.web.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TestRepository extends JpaRepository<Test, Integer> {

}
