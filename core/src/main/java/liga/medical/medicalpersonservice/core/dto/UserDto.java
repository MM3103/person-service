package liga.medical.medicalpersonservice.core.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    public Long id;

    public String username;

    public Set<RoleDto> roles;
}
