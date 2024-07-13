package com.example.demo.Controller;

import com.example.demo.Service.impl.CreditCardServiceImpl;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Dto.CreditCardAddRequestDTO;
import com.example.demo.entity.Dto.CreditCardValidationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardServiceImpl creditCardService;

    @PostMapping("request")
    public ResponseEntity<CreditCard> requestCreditCard(@RequestBody CreditCardAddRequestDTO creditCard) {
        return ResponseEntity.ok(this.creditCardService.RequestCreditCard(creditCard));
    }

    @PostMapping("validation")
    public ResponseEntity<CreditCard> validationCreditCard(@RequestBody CreditCardValidationRequestDTO creditCard) {
        return ResponseEntity.ok(this.creditCardService.RequestValidationCreditCard(creditCard));
    }

    @GetMapping("requests")
    public ResponseEntity<List<CreditCard>> getRequestsCreditCard() {
        return ResponseEntity.ok(this.creditCardService.getRequestCreditCards());
    }
}
