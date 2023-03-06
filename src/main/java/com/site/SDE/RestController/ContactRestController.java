package com.site.SDE.RestController;


import com.site.SDE.Entite.Contact;
import com.site.SDE.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.POST)
    public Contact ajouterContact(@RequestBody Contact contact){
        return contactService.ajouterContact(contact);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Contact modifierContact(@PathVariable("id")Long id,@RequestBody Contact contact){
        Contact newContact=contactService.modifierContact(contact);
        return newContact;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerContact(@PathVariable("id")Long id){
        contactService.supprimerContact(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Contact>getContactById(@PathVariable("id")Long id){
        Optional<Contact>contact=contactService.getContactById(id);
        return contact;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> lstOffres(){
        return contactService.lstContact();
    }
}