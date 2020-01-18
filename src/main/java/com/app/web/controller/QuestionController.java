package com.app.web.controller;

import com.app.web.model.Question;
import com.app.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(
            value = "/lectures/{id}/questions",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<Question>> getQuestions(@PathVariable("id") Integer id) {
        List<Question> questions = questionService.findQuestionsByLecture_Id(id);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping(value = "/lectures/{id}/test")
    public String viewQuestions(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "test";
    }

}
