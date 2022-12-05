package liga.medical.medicalpersonservice.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import liga.medical.medicalpersonservice.core.model.Illness;
import liga.medical.medicalpersonservice.core.service.IllnessService;
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
@RequestMapping("/illness")
public class IllnessController {

    private final IllnessService illnessService;

    @Autowired
    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping("/getAllIllness")
    @Operation(summary = "Get all illness")
    public List<Illness> getAllIllness() {
        return illnessService.getAllIllness();
    }

    @GetMapping("/getIllnessById/{id}")
    @Operation(summary = "Get illness by id")
    public ResponseEntity<Illness> getIllnessById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(illnessService.getIllnessById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new illness")
    public void addIllness(@RequestBody Illness newContact) {
        illnessService.addIllness(newContact);
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update illness  by id")
    public void updateIllness(
            @PathVariable(value = "id") Long id,
            @RequestBody Illness newIllness) throws EntityNotFoundException {
        illnessService.updateIllness(id, newIllness);
    }
}
