package com.example.demo.Service;

import com.example.demo.entity.Dto.SubmitRequestDTO;
import com.example.demo.security.user.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> getRequestUsers();
    void submitRequestUser(SubmitRequestDTO req);

    boolean deleteUser(Integer id);

    User updateUser(Integer idUser, User user);

    User getUser(Integer idUser);

    List<User> getAllUser();

    Authentication Authenticate(String name, String password);

}

