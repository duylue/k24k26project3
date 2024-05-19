package com.example.K2426Project3.service;

import com.example.K2426Project3.model.User;

public interface UserService {
     void register(User user);
    User findByUsername(String username);
    User findByUsernameAndPass(String username,String password);
}
