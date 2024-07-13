package com.example.demo.Controller;

import com.example.demo.Service.impl.ContactServiceImpl;
import com.example.demo.entity.Contact;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Dto.ContactSaveRequestDTO;
import com.example.demo.entity.Dto.ContactValidationRequestDTO;
import com.example.demo.entity.Dto.CreditCardAddRequestDTO;
import com.example.demo.entity.Dto.CreditCardValidationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("request")
    public ResponseEntity<Contact> requestContact(@RequestBody ContactSaveRequestDTO request) {
        return ResponseEntity.ok(this.contactService.saveContact(request));
    }

    @PostMapping("validation")
    public ResponseEntity<Contact> validationContact(@RequestBody ContactValidationRequestDTO request) {
        return ResponseEntity.ok(this.contactService.ValidateContact(request.getId(), request.getStatus()));
    }

    @GetMapping("requests")
    public ResponseEntity<List<Contact>> getRequestsContact() {
        return ResponseEntity.ok(this.contactService.requestContacts());
    }

    @GetMapping("requests/modification")
    public ResponseEntity<List<Contact>> getRequestsUpdateContact() {
        return ResponseEntity.ok(this.contactService.requestContactsUpdate());
    }

    @GetMapping("requests/delete")
    public ResponseEntity<List<Contact>> getRequestsDeleteContact() {
        return ResponseEntity.ok(this.contactService.requestContactsDelete());
    }

    @GetMapping("requests/other")
    public ResponseEntity<List<Contact>> getRequestsOtherContact() {
        return ResponseEntity.ok(this.contactService.requestContactsOther());
    }
}
