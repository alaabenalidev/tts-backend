package com.example.demo.entity;

import com.example.demo.security.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;
    double annualIncome;
    @Column(unique = true)
    String cardNumber;
    LocalDate expirationDate;
    Date createDate =new Date();
    StatusCreditCard status = StatusCreditCard.REQUEST;

    @OneToOne
    @JsonBackReference
    private BankAccount bankAccount;

}
