package dev.uofc_chessclub.Chess.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "https://your-vercel-frontend.vercel.app"})
@RestController
@RequestMapping("api/v1/contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    // Get all contacts
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    // Create a new contact
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact newContact) {
        Contact createdContact = contactService.saveContact(newContact);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

    // Delete a contact by name
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteContactByName(@PathVariable String name) {
        boolean isDeleted = contactService.deleteContactByName(name);
        if (isDeleted) {
            return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        }
    }
}
