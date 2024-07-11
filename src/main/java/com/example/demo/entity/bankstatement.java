package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class bankstatement {
    @Id
    @Generated
    private Integer idstatement;
    private Integer idaccount ;
    private Number InitialSold;
    private Number FinalSold;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "bankaccount_id")
    private BankAccount bankAccount;
}
