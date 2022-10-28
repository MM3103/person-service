package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.repository.PersonDataRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonDataService {

    private final PersonDataRepository personDataRepository;

    public PersonDataService(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    public List<PersonData> getAllPersonData() {
        return personDataRepository.findAll();
    }

    public PersonData getPersonDataById(Long id) throws EntityNotFoundException {
        return personDataRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Person data not found for id: " + id));
    }

    public void addPersonData(PersonData newPersonData) {
        personDataRepository.save(newPersonData);
    }
}
