package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;
    private Integer Amount;
    private Date Date;
    private Integer cin; // Nouvelle colonne CIN de type entier
    private String name; // Nouvelle colonne Name de type chaîne de caractères
    private String rib; // Nouvelle colonne RIB
    @ManyToOne
    @JoinColumn(name = "bankaccount_id")
    private BankAccount bankAccount;
}
