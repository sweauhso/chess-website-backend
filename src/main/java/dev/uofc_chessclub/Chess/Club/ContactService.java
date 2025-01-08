package dev.uofc_chessclub.Chess.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    // Listing all contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Creating new contact
    public Contact saveContact(Contact newcontact) {
        return contactRepository.save(newcontact);
    }

    // Deleting new contact
    public boolean deleteContactByName(String name) {
        Optional<Contact> contact = contactRepository.findByName(name);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
            return true;
        }
        return false;
    }

}
