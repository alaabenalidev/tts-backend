package com.example.demo.Controller;

import com.example.demo.Service.TransactionService;
import com.example.demo.entity.BankTransaction;
import com.example.demo.entity.Dto.AddTransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@RequestBody AddTransactionRequestDTO bankTransaction) {
        return ResponseEntity.ok().body(transactionService.addBankTransaction(bankTransaction));
    }

    @DeleteMapping("/delete/{idTransaction}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Integer idTransaction) {
        transactionService.deleteTransaction(idTransaction);
        return ResponseEntity.ok("success delete Transaction");
    }

    @PutMapping("/update/{idTransaction}")
    public ResponseEntity<String> updateTransaction(@PathVariable("idTransaction") Integer idTransaction, @RequestBody BankTransaction BankTransaction) {
        transactionService.updateTransaction(idTransaction, BankTransaction);
        return ResponseEntity.ok("success update Transaction");
    }

    @GetMapping("/{idTransaction}")
    public ResponseEntity<String> getTransaction(@PathVariable("idTransaction") Integer idTransaction) {
        transactionService.getTransaction(idTransaction);
        return ResponseEntity.ok("success get Transaction");
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> getAllTransaction() {
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }
}