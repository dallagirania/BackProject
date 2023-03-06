package com.site.SDE.Service;

import com.site.SDE.Entite.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact ajouterContact(Contact contact);
    Contact modifierContact(Contact contact );
    List<Contact> lstContact();
    Optional<Contact> getContactById(Long id);
    void supprimerContact(Long id);
}
