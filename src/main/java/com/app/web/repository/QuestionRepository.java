package com.app.web.repository;

import com.app.web.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findQuestionsByLecture_Id(int id);

}
