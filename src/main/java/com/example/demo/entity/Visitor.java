package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    @Id
    @Generated
    private  Integer idVisitor;
    private String Firstname;
    private String Lastname;
    private Number phone;
    private String mail;

    @OneToOne
    @JoinColumn(name = "bankaccount_id")
    private BankAccount bankAccount;
}
