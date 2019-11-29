package com.app.web.service;

import com.app.web.model.Role;
import com.app.web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void delete(Role role){
        roleRepository.delete(role);
    }

    public Role getOne(Integer id){
        return roleRepository.getOne(id);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

}
