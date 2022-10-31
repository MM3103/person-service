package liga.medical.medicalpersonservice.core.api;

import liga.medical.medicalpersonservice.core.dto.UserDto;
import liga.medical.medicalpersonservice.core.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

    User findByUsername(String username);

    List<UserDto> getUsers();

    boolean deleteUser(Long userId);
}
