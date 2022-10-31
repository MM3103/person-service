package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
