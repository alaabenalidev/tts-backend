package com.example.demo.Service;

import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.Dto.AddTransactionRequestDTO;

import java.util.List;

public interface TransactionService {
    BankTransaction addBankTransaction(AddTransactionRequestDTO bankTransaction);

    boolean deleteTransaction(Integer idTransaction);

    BankTransaction updateTransaction(Integer idTransaction, BankTransaction bankTransaction);

    BankTransaction getTransaction(Integer idTransaction);

    List<BankTransaction> getAllTransaction();
}
