package com.example.demo.Controller;

import com.example.demo.Service.BankAccountService;
import com.example.demo.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankaccount")
@CrossOrigin("*")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/add")
    public String addBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.addBankAccount(bankAccount);
        return "success add BankAccount";
    }

    @DeleteMapping("/{idaccount}")
    public String deleteBankAccount(@PathVariable("idaccount") Integer idaccount) {
        bankAccountService.deleteBankAccount(idaccount);
        return "success delete BankAccount";
    }

    @PutMapping("/{idaccount}")
    public String updateBankAccount(@PathVariable("idaccount") Integer idaccount, @RequestBody BankAccount bankAccount) {
        bankAccountService.updateBankAccount(idaccount, bankAccount);
        return "success update BankAccount";
    }

    @GetMapping("/{idaccount}")
    public String getBankAccount(@PathVariable("idaccount") Integer idaccount) {
        bankAccountService.getBankAccount(idaccount);
        return "success get BankAccount";
    }
    @GetMapping("/fetchAll")
    public String getAllBankAccount() {
        bankAccountService.getAllBankAccount();
        return "success get all BankAccount";
    }
}
