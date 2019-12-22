package com.app.web.service;

import com.app.web.model.User;
import com.app.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User getOne(Integer id){
        return userRepository.getOne(id);
    }

    public User save(User user){
        user.setActive(true);
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByName(String jmeno) {
        return userRepository.findUserByName(jmeno);
    }

}
