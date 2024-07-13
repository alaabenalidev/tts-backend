package com.example.demo.repository;

import com.example.demo.entity.Checkbook;
import com.example.demo.entity.StatusCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckbookRepository extends JpaRepository<Checkbook,Long> {

    List<Checkbook> findAllByStatus(StatusCreditCard status);
}
