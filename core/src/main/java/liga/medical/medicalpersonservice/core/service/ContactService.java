package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.mapping.ContactMapper;
import liga.medical.medicalpersonservice.core.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactMapper contactMapper;

    public ContactService(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    public List<Contact> getAllContacts() {
        return contactMapper.getAllContacts();
    }

    public Contact getContactById(long id) {
        return contactMapper.getContactById(id);
    }

    public void addContact(Contact contact) {
        contactMapper.addContact(contact);
    }

    public void updateContact(Long id, Contact newContact) {
        Contact contact= contactMapper.getContactById(id);
        contact.setPhoneNumber(newContact.getPhoneNumber());
        contact.setEmail(newContact.getEmail());
        contact.setProfileLink(newContact.getProfileLink());
        contactMapper.addContact(contact);
    }
}
