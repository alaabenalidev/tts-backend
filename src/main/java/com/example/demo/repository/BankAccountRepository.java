package com.example.demo.repository;

import com.example.demo.entity.BankAccount;
import com.example.demo.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository <BankAccount, Integer> {

    Boolean existsByRib(String rib);
    BankAccount findByRib(String rib);
    BankAccount findByUser(User u);
}
