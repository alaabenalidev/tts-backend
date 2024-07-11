package com.example.demo.Service;

import com.example.demo.entity.BankTransaction;

import java.util.List;

public interface TransactionService {
    BankTransaction addBankTransaction(BankTransaction bankTransaction);

    boolean deleteTransaction(Integer idTransaction);

    BankTransaction updateTransaction(Integer idTransaction, BankTransaction bankTransaction);

    BankTransaction getTransaction(Integer idTransaction);

    List<BankTransaction> getAllTransaction();
}
