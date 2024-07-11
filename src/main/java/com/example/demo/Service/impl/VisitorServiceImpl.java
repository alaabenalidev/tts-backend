package com.example.demo.Service.impl;

import com.example.demo.Service.VisitorService;
import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    VisitorRepository rep;


    @Override
    public Visitor addVisitor(Visitor visitor) {
        if (rep.save(visitor) != null) {
            return visitor;
        }
        return null;
    }

    @Override
    public boolean deleteVisitor(Integer idVisitor) {
        rep.deleteById(idVisitor);
        return !rep.existsById(idVisitor);
    }


    @Override
    public Visitor updateVisitor(Integer idVisitor, Visitor visitor) {
        visitor.setIdVisitor(idVisitor);
        rep.save(visitor);
        return rep.findById(idVisitor).get();
    }


    @Override
    public Visitor getVisitor(Integer idVisitor) {
        return rep.findById(idVisitor).get();
    }

    @Override
    public List<Visitor> getAllVisitor() {
        return rep.findAll();
    }
}
