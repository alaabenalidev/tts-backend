package com.example.demo.Service.impl;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Dto.CreditCardAddRequestDTO;
import com.example.demo.entity.Dto.CreditCardValidationRequestDTO;
import com.example.demo.entity.StatusCreditCard;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class CreditCardServiceImpl {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    UserServiceImpl userService;

    public CreditCard save(CreditCard creditCard) {
        return null;
    }

    public CreditCard RequestCreditCard(CreditCardAddRequestDTO requestDTO) {
        User user = userService.getAuthenticatedUser();
        CreditCard creditCard = new CreditCard();
        BankAccount bankAccount = this.bankAccountRepository.findByUser(user);
        creditCard.setBankAccount(bankAccount);
        creditCard.setAnnualIncome(requestDTO.annualIncome());
        creditCard.setStatus(StatusCreditCard.REQUEST);
        return this.creditCardRepository.save(creditCard);
    }

    public CreditCard RequestValidationCreditCard(CreditCardValidationRequestDTO requestDTO) {
        User user = userService.getAuthenticatedUser();
        BankAccount bankAccount = this.bankAccountRepository.findByUser(user);
        CreditCard creditCard = this.creditCardRepository.findById(requestDTO.getCreditCard()).get();
        creditCard.setStatus(requestDTO.getStatus() ? StatusCreditCard.APPROVED : StatusCreditCard.REFFUSED);
        LocalDate date = LocalDate.now();
        date = date.plus(5, ChronoUnit.YEARS);
        creditCard.setExpirationDate(date);
        creditCard = this.creditCardRepository.save(creditCard);
        bankAccount.setCreditCard(creditCard);
        this.bankAccountRepository.save(bankAccount);
        return creditCard;
    }

    public List<CreditCard> getRequestCreditCards() {
        return this.creditCardRepository.findByStatus(StatusCreditCard.REQUEST);
    }
}
