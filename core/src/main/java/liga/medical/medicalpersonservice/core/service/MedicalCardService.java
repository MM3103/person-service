package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.mapping.MedicalCardMapper;
import liga.medical.medicalpersonservice.core.model.MedicalCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardService {

    private final MedicalCardMapper medicalCardMapper;

    public MedicalCardService(MedicalCardMapper medicalCardMapper) {
        this.medicalCardMapper = medicalCardMapper;
    }

    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardMapper.getAllMedicalCards();
    }

    public MedicalCard getMedicalCardById(long id) {
        return medicalCardMapper.getMedicalCardById(id);
    }

    public void addMedicalCard(MedicalCard medicalCard) {
        medicalCardMapper.addMedicalCard(medicalCard);
    }

    public void updateMedicalCard(Long id, MedicalCard newMedicalCard) {
        MedicalCard medicalCard= medicalCardMapper.getMedicalCardById(id);
        medicalCard.setClientStatus(newMedicalCard.getClientStatus());
        medicalCard.setComment(newMedicalCard.getComment());
        medicalCard.setMedStatus(newMedicalCard.getMedStatus());
        medicalCard.setRegistryDt(newMedicalCard.getRegistryDt());
        medicalCardMapper.addMedicalCard(medicalCard);
    }
}
