package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
