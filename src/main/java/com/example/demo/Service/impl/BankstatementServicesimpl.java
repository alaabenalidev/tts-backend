package com.example.demo.Service.impl;

import com.example.demo.Service.bankstatementServices;
import com.example.demo.entity.bankstatement;
import com.example.demo.repository.BankstatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankstatementServicesimpl implements bankstatementServices {
    @Autowired
    BankstatementRepository rep;


    @Override
    public bankstatement addbankstatement(bankstatement bankstatement) {
        if (rep.save(bankstatement) != null) {
            return bankstatement;
        }
        return null;
    }

    @Override
    public boolean deletebankstatement(Integer idstatement) {
        rep.deleteById(idstatement);
            return !rep.existsById(idstatement);
    }

    @Override
    public bankstatement updatebankstatement(Integer idstatement, bankstatement bankstatement) {
        bankstatement.setIdstatement(idstatement);
        rep.save(bankstatement);
            return rep.findById(idstatement).get();
    }

    @Override
    public bankstatement getbankstatement(Integer idstatement) {
        return rep.findById(idstatement).get();
    }

    @Override
    public List<bankstatement> getAllBankstatement() {
        return rep.findAll();
    }


}
