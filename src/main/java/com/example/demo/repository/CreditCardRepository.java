package com.example.demo.repository;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.StatusCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    List<CreditCard> findByStatus(StatusCreditCard statusCreditCard);
}
