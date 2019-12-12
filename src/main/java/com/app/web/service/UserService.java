package com.app.web.service;

import com.app.web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    void delete(User user);

    User getOne(Integer id);

    User save(User user);

    Optional<User> findUserByName(String jmeno);
}
