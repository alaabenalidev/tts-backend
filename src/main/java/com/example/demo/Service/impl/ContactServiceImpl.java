package com.example.demo.Service.impl;

import com.example.demo.entity.Contact;
import com.example.demo.entity.Dto.ContactSaveRequestDTO;
import com.example.demo.entity.EContactStatus;
import com.example.demo.entity.StatusCreditCard;
import com.example.demo.repository.ContactRepository;
import com.example.demo.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserServiceImpl userService;

    public Contact saveContact(ContactSaveRequestDTO requestDTO) {
        Contact contact = new Contact();
        User user = this.userService.getAuthenticatedUser();
        contact.setUser(user);
        contact.setMessage(requestDTO.message());
        contact.setType(requestDTO.status() == 1 ? EContactStatus.ACCOUNT_MODIFICATION : requestDTO.status() == 2 ? EContactStatus.ACCOUNT_DELETION : EContactStatus.OTHER);
        return this.contactRepository.save(contact);
    }

    public Contact ValidateContact(Long id, boolean status) {
        Contact contact = this.contactRepository.findById(id).get();
        contact.setStatus(status ? StatusCreditCard.APPROVED : StatusCreditCard.REFFUSED);
        return this.contactRepository.save(contact);
    }

    public List<Contact> requestContacts() {
        return this.contactRepository.findAllByStatus(StatusCreditCard.REQUEST);
    }

    public List<Contact> requestContactsUpdate() {
        return this.contactRepository.findAllByStatusAndType(StatusCreditCard.REQUEST,EContactStatus.ACCOUNT_MODIFICATION);
    }

    public List<Contact> requestContactsDelete() {
        return this.contactRepository.findAllByStatusAndType(StatusCreditCard.REQUEST,EContactStatus.ACCOUNT_DELETION);
    }

    public List<Contact> requestContactsOther() {
        return this.contactRepository.findAllByStatusAndType(StatusCreditCard.REQUEST,EContactStatus.OTHER);
    }
}
