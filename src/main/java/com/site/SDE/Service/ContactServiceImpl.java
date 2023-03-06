package com.site.SDE.Service;

import com.site.SDE.Entite.Contact;
import com.site.SDE.Repository.ContactRepository;
import com.site.SDE.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact ajouterContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact modifierContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> lstContact() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void supprimerContact(Long id) {
        contactRepository.deleteById(id);

    }
}