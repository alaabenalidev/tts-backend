package com.example.demo.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    boolean deleteUser(Integer id);

    User updateUser(Integer idUser, User user);

    User getUser(Integer idUser);

    List<User> getAllUser();

    Authentication Authenticate(String name, String password);

}

