package com.example.demo.Controller;

import com.example.demo.Service.TransactionService;
import com.example.demo.entity.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService s;
    @Autowired
    public TransactionController(TransactionService s) {
        this.s = s;
    }

    @PostMapping("/add")
    public String addTransaction(@RequestBody BankTransaction bankTransaction) {
        s.addBankTransaction(bankTransaction);
        return "success add Transaction";
    }

    @DeleteMapping("/delete/{idTransaction}")
    public String deleteTransaction(@PathVariable Integer idTransaction) {
        s.deleteTransaction(idTransaction);
        return "success delete Transaction";
    }

    @PutMapping("/update/{idTransaction}")
    public String updateTransaction(@PathVariable("idTransaction") Integer idTransaction, @RequestBody BankTransaction BankTransaction) {
        s.updateTransaction(idTransaction, BankTransaction);
        return "success update Transaction";
    }

    @GetMapping("/{idTransaction}")
    public String getTransaction(@PathVariable("idTransaction") Integer idTransaction) {
        s.getTransaction(idTransaction);
        return "success get Transaction";
    }

    @GetMapping("/fetchAll")
    public String getAllTransaction() {
        s.getAllTransaction();
        return "success get all Transaction";
    }
}