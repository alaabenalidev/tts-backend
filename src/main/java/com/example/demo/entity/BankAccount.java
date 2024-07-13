package com.example.demo.entity;

import com.example.demo.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaccount;
    private Double sold;
    private String type;
    @Column(unique = true)
    private String rib;
    private LocalDate dateOp=LocalDate.now();
    private LocalDate dateCl=LocalDate.now();

    @OneToMany
    private List<BankTransaction> transactions; // Renamed from 'Transaction'

    @OneToMany(mappedBy = "bankAccount")
    private List<bankstatement> bankStatements;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @OneToOne
    private CreditCard creditCard;

}
