package com.example.demo.Controller;

import com.example.demo.entity.Visitor;
import com.example.demo.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitors")
@CrossOrigin("*")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/add")
    public String addVisitor(@RequestBody Visitor visitor) {
        visitorService.addVisitor(visitor);
        return "success add Visitor";
    }

    @DeleteMapping("/delete/{idVisitor}")
    public String deleteVisitor(@PathVariable Integer idVisitor) {
        visitorService.deleteVisitor(idVisitor);
        return "success delete Visitor";
    }

    @PutMapping("/update/{idVisitor}")
    public String updateVisitor(@PathVariable Integer idVisitor, @RequestBody Visitor visitor) {
        visitorService.updateVisitor(idVisitor, visitor);
        return "success update Visitor";
    }

    @GetMapping("/get/{idVisitor}")
    public Visitor getVisitor(@PathVariable Integer idVisitor) {
        return visitorService.getVisitor(idVisitor);

    }

    @GetMapping("/fetchAll")
    public String getAllVisitor() {
        visitorService.getAllVisitor();
        return "success get all Visitor";
    }
}
