package com.app.web.service;

import com.app.web.model.Role;
import com.app.web.model.User;
import com.app.web.repository.RoleRepository;
import com.app.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.deleteById(user.getIdUser());
    }

    public User getOne(Integer id){
        return userRepository.getOne(id);
    }

    public User save(User user){
        Role role = roleRepository.findByRoleType("USER");
        user.setActive(true);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
