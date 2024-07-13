package com.example.demo.Service.impl;

import com.example.demo.Service.BankAccountService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Dto.SubmitRequestDTO;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.security.user.AccountStatus;
import com.example.demo.security.user.User;
import com.example.demo.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public User addUser(User user) {
        return null;
    }

    public List<com.example.demo.security.user.User> getRequestUsers() {
        return userRepository.findAllByAccountStatus(AccountStatus.REQUEST);
    }

    @Override
    public void submitRequestUser(SubmitRequestDTO requestDTO) {
        User userData = this.userRepository.findById(requestDTO.user()).get();
        userData.setAccountStatus(requestDTO.status()?AccountStatus.ACCEPTED:AccountStatus.REFUSED);
        userData.setEnabled(requestDTO.status()?true:false);
        userData = this.userRepository.save(userData);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUser(userData);
        bankAccount.setSold(0.0);
        Random random = new Random();
        long n = (long) (100000000000000L + random.nextFloat() * 900000000000000L);
        bankAccount.setRib(n+"");
        this.bankAccountRepository.save(bankAccount);
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

    public User getAuthenticatedUser() {
        String authenticatedUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userRepository.findByEmail(authenticatedUserEmail).orElseThrow(() -> new UsernameNotFoundException("Invalid user email " + authenticatedUserEmail));
    }
}

