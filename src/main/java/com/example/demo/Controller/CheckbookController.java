package com.example.demo.Controller;

import com.example.demo.Service.impl.CheckbookServiceImpl;
import com.example.demo.entity.Checkbook;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Dto.CheckbookValidationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("checkbook")
public class CheckbookController {

    @Autowired
    private CheckbookServiceImpl checkbookService;

    @PostMapping("request/{quantite}")
    public ResponseEntity<Checkbook> requestCreditCard(@PathVariable int quantite) {
        return ResponseEntity.ok(this.checkbookService.saveRequest(quantite));
    }

    @PostMapping("validation")
    public ResponseEntity<Checkbook> validationCreditCard(@RequestBody CheckbookValidationRequestDTO creditCard) {
        return ResponseEntity.ok(this.checkbookService.validateRequest(creditCard));
    }

    @GetMapping("requests")
    public ResponseEntity<List<Checkbook>> getRequestsCreditCard() {
        return ResponseEntity.ok(this.checkbookService.listRequest());
    }
}
