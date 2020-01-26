package com.app.web.controller;

import com.app.web.model.Statistic;
import com.app.web.model.User;
import com.app.web.service.LectureService;
import com.app.web.service.StatisticService;
import com.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class StatisticController {

    @Autowired
    private UserService userService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private LectureService lectureService;

    @RequestMapping(value = "/statistics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Statistic createStats(
            @RequestBody Statistic statistic,
            @RequestParam(value = "lectureId", required = false) String lectureId
    ) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        User user = userService.findUserByUsername(username);
        statistic.setUser(user);

        statistic.setCreated(LocalDate.now());
        statistic.setLecture(lectureService.getOne(Integer.parseInt(lectureId)));

        return statisticService.save(statistic);
    }

}
