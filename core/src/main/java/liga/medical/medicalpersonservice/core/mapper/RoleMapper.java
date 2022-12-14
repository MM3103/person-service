package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.dto.RoleDto;
import liga.medical.medicalpersonservice.core.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);

    List<RoleDto> toDtoList(List<Role> role);

    List<Role> toEntityList(List<RoleDto> roleDto);
}
