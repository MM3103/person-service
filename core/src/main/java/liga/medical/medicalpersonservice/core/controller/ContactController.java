package liga.medical.medicalpersonservice.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import liga.medical.medicalpersonservice.core.model.Contact;
import liga.medical.medicalpersonservice.core.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getAllContacts")
    @Operation(summary = "Get all contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/getContactById/{id}")
    @Operation(summary = "Get contact by id")
    public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(contactService.getContactById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new contact")
    public void addContact(@RequestBody Contact newContact) {
        contactService.addContact(newContact);
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update contact  by id")
    public void updateContact(
            @PathVariable(value = "id") Long id,
            @RequestBody Contact newContact)  {
        contactService.updateContact(id, newContact);
    }
}
