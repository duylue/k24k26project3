package com.example.K2426Project3.service.impl;

import com.example.K2426Project3.model.User;
import com.example.K2426Project3.repository.UserRepository;
import com.example.K2426Project3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPass(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
