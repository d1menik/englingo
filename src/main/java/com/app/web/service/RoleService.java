package com.app.web.service;

import com.app.web.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void delete(Role role);

    Role getOne(Integer id);

    Role save(Role role);

}
