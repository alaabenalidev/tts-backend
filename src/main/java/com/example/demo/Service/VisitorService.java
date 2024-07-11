package com.example.demo.Service;

import com.example.demo.entity.Visitor;

import java.util.List;

public interface VisitorService {
    Visitor addVisitor(Visitor visitor);

    boolean deleteVisitor(Integer idVisitor);

    Visitor updateVisitor(Integer idVisitor, Visitor visitor);

    Visitor getVisitor(Integer idVisitor);

    List<Visitor> getAllVisitor();
}
