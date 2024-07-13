package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Checkbook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private StatusCreditCard status = StatusCreditCard.REQUEST;

    @ManyToOne
    private BankAccount bankAccount;

}
