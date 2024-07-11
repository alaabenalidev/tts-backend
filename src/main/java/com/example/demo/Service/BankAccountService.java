package com.example.demo.Service;

import com.example.demo.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount bankAccount);

    boolean deleteBankAccount(Integer idaccount);

    BankAccount updateBankAccount(Integer idaccount, BankAccount bankAccount);

    BankAccount getBankAccount(Integer idaccount);

    List<BankAccount> getAllBankAccount();
}

