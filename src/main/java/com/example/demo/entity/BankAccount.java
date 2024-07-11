package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaccount;
    private Double sold;
    private String type;
    private LocalDate dateOp;
    private LocalDate dateCl;

    @OneToMany(mappedBy = "bankAccount")
    private List<BankTransaction> transactions; // Renamed from 'Transaction'

    @OneToOne(mappedBy = "bankAccount")
    private Visitor visitor;

    @OneToMany(mappedBy = "bankAccount")
    private List<bankstatement> bankStatements;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

}
