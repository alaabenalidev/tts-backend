package com.example.demo.repository;

import com.example.demo.entity.Contact;
import com.example.demo.entity.EContactStatus;
import com.example.demo.entity.StatusCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByStatus(StatusCreditCard status);
    List<Contact> findAllByStatusAndType(StatusCreditCard status, EContactStatus type);
}
