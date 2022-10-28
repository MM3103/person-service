package liga.medical.medicalpersonservice.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/personData")
public class PersonDataController {

    private final PersonDataService personDataService;

    @Autowired
    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping("/getAllPersonData")
    @Operation(summary = "Get all person data")
    public List<PersonData> getAllPersonData() {
        return personDataService.getAllPersonData();
    }

    @GetMapping("/getPersonDataById/{id}")
    @Operation(summary = "Get person data by id")
    public ResponseEntity<PersonData> getPersonDataById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(personDataService.getPersonDataById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new person data")
    public void addPersonData(@RequestBody PersonData newPersonData) {
        personDataService.addPersonData(newPersonData);
    }
}
