package com.example.demo.Controller;

import com.example.demo.Service.bankstatementServices;
import com.example.demo.entity.bankstatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Bankstatement")
@CrossOrigin("*")
public class BankstatementController {

    private final bankstatementServices bankstatementServices;

    @Autowired
    public BankstatementController(bankstatementServices bankstatementServices) {
        this.bankstatementServices = bankstatementServices;
    }

    @PostMapping("/add")
    public String addBankstatement(@RequestBody bankstatement bankstatement) {
        bankstatementServices.addbankstatement(bankstatement);
        return "success add Bankstatement";
    }

    @DeleteMapping("/{idstatement}")
    public String deleteBankstatement(@PathVariable Integer idstatement) {
        bankstatementServices.deletebankstatement(idstatement);
        return "success delete Bankstatement";
    }

    @PutMapping("/{idstatement}")
    public String updateBankstatement(@PathVariable Integer idstatement, @RequestBody bankstatement bankstatement) {
        bankstatementServices.updatebankstatement(idstatement, bankstatement);
        return "success update Bankstatement";
    }

    @GetMapping("/{idstatement}")
    public String getBankstatement(@PathVariable("idstatement") Integer idstatement) {
        bankstatementServices.getbankstatement(idstatement);
        return "success get Bankstatement";
    }

    @GetMapping("/fetchAll")
    public String getAllBankstatement() {
        bankstatementServices.getAllBankstatement();
        return "success get all BankAccount";
    }
}


