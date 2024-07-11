package com.example.demo.repository;

import com.example.demo.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<BankTransaction, Integer> {

}
