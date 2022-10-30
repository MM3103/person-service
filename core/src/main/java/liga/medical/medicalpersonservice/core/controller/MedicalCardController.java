package liga.medical.medicalpersonservice.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import liga.medical.medicalpersonservice.core.model.MedicalCard;
import liga.medical.medicalpersonservice.core.service.MedicalCardService;
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
@RequestMapping("/medicalCard")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    @Autowired
    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("/getAllMedicalCards")
    @Operation(summary = "Get all medical cards")
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.getAllMedicalCards();
    }

    @GetMapping("/getMedicalCardById/{id}")
    @Operation(summary = "Get medical card by id")
    public ResponseEntity<MedicalCard> getMedicalCardById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(medicalCardService.getMedicalCardById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new medical card")
    public void addMedicalCard(@RequestBody MedicalCard newMedicalCard) {
        medicalCardService.addMedicalCard(newMedicalCard);
    }
}
