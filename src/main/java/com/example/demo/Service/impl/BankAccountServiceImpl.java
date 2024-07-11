package com.example.demo.Service.impl;

import com.example.demo.Service.BankAccountService;
import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository rep;

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        if (rep.save(bankAccount) != null) {
            return bankAccount;
        }
        return null;
    }

    @Override
    public boolean deleteBankAccount(Integer idaccount) {
        rep.deleteById(idaccount);
            return !rep.existsById(idaccount);
    }

    @Override
    public BankAccount updateBankAccount(Integer idaccount, BankAccount bankAccount) {
    bankAccount.setIdaccount(idaccount);
    rep.save(bankAccount);
        return rep.findById(idaccount).get();
    }

    @Override
        public BankAccount getBankAccount(Integer idaccount) {
        return rep.findById(idaccount).get();
        }

    @Override
    public List<BankAccount> getAllBankAccount() {
        return rep.findAll();
    }
}
