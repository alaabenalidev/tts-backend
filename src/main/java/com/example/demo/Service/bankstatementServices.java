package com.example.demo.Service;

import com.example.demo.entity.bankstatement;

import java.util.List;

public interface bankstatementServices {
    bankstatement addbankstatement(bankstatement bankstatement);

    boolean deletebankstatement(Integer idstatement);

    bankstatement updatebankstatement(Integer idstatement, bankstatement bankstatement);

    bankstatement getbankstatement(Integer idstatement);

    List<bankstatement> getAllBankstatement();
}

