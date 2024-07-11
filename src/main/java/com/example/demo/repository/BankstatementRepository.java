package com.example.demo.repository;

import com.example.demo.entity.bankstatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankstatementRepository extends JpaRepository<bankstatement, Integer> {
}