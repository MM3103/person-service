package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.model.Illness;
import liga.medical.medicalpersonservice.core.repository.IllnessRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class IllnessService {

    private final IllnessRepository illnessRepository;

    public IllnessService(IllnessRepository illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    public List<Illness> getAllIllness() {
        return illnessRepository.findAll();
    }

    public Illness getIllnessById(long id) {
        return illnessRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Illness not found for id: " + id));
    }

    public void addIllness(Illness illness) {
        illnessRepository.save(illness);
    }
}
