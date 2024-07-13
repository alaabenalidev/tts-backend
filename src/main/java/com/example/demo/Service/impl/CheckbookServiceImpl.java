package com.example.demo.Service.impl;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Checkbook;
import com.example.demo.entity.Dto.CheckbookValidationRequestDTO;
import com.example.demo.entity.StatusCreditCard;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.CheckbookRepository;
import com.example.demo.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckbookServiceImpl {

    @Autowired
    private CheckbookRepository checkbookRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserServiceImpl userService;

    public Checkbook saveRequest(int checkbookNbre) {
        User user = this.userService.getAuthenticatedUser();
        BankAccount bankAccount = this.bankAccountRepository.findByUser(user);

        Checkbook checkbook = new Checkbook();
        checkbook.setQuantity(checkbookNbre);
        checkbook.setBankAccount(bankAccount);
        return this.checkbookRepository.save(checkbook);
    }

    public Checkbook validateRequest(CheckbookValidationRequestDTO requestDTO) {
        Checkbook checkbook =this.checkbookRepository.findById(requestDTO.id()).get();
        checkbook.setStatus(requestDTO.status()?StatusCreditCard.APPROVED:StatusCreditCard.REFFUSED);
        return this.checkbookRepository.save(checkbook);
    }

    public List<Checkbook> listRequest() {
        return this.checkbookRepository.findAllByStatus(StatusCreditCard.REQUEST);
    }
}
