package com.example.demo.Service.impl;

import com.example.demo.Service.TransactionService;
import com.example.demo.entity.BankAccount;
import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.Dto.AddTransactionRequestDTO;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository rep;
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    public BankTransaction addBankTransaction(AddTransactionRequestDTO bankTransaction) {
        if (this.bankAccountRepository.existsByRib(bankTransaction.rib())) {
            BankAccount bankAccountReciever = bankAccountRepository.findByRib(bankTransaction.rib());
            User user = userService.getAuthenticatedUser();
            BankAccount bankAccountSender = bankAccountRepository.findByUser(user);
            BankTransaction transaction = new BankTransaction();
            transaction.setAmount(bankTransaction.amount());
            transaction.setBankAccountSender(bankAccountSender);
            transaction.setBankAccountReceiver(bankAccountReciever);
            this.rep.save(transaction);
            return transaction;
        }
        throw new RuntimeException();
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
