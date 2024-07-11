package com.example.demo.Service.impl;

import com.example.demo.Service.TransactionService;
import com.example.demo.entity.BankTransaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository rep;

    @Override
    public BankTransaction addBankTransaction(BankTransaction bankTransaction) {
        if (rep.save(bankTransaction) != null) {
            return bankTransaction;
        }
        return null;
    }

    @Override
    public boolean deleteTransaction(Integer idTransaction) {
        rep.deleteById(idTransaction);
        return !rep.existsById(idTransaction);
    }


    @Override
    public BankTransaction updateTransaction(Integer idTransaction, BankTransaction transaction) {
        transaction.setIdTransaction(idTransaction);
        rep.save(transaction);
        return rep.findById(idTransaction).get();
    }
    @Override
    public BankTransaction getTransaction(Integer idTransaction) {
        return rep.findById(idTransaction).get();
    }
    @Override
    public List<BankTransaction> getAllTransaction() {
        return rep.findAll();
    }
}
