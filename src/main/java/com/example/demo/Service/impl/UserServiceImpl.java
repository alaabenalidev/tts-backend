package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer idUser) {
        return false;
    }

    @Override
    public User updateUser(Integer idUser, User user) {
        return null;
    }

    @Override
    public User getUser(Integer idUser) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public Authentication Authenticate(String name, String password) {
        return null;
    }
}

