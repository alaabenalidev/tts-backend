package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;
    private double Amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Date = new Date();

    @ManyToOne
    @JoinColumn(name = "sender_bankaccount_id")
    private BankAccount bankAccountSender;

    @ManyToOne
    @JoinColumn(name = "receiver_bankaccount_id")
    private BankAccount bankAccountReceiver;
}
