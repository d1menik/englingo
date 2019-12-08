package com.app.web.service;

import com.app.web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void delete(User user);

    User getOne(Integer id);

    User save(User user);

}
