package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Signal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository  extends JpaRepository<Signal, Long> {
}
