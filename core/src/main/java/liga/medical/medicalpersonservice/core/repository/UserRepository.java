package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
