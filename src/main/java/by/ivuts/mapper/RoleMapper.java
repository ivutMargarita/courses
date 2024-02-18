package by.ivuts.mapper;

import by.ivuts.dto.RoleCreateAndUpdateDto;
import by.ivuts.dto.RoleDto;
import by.ivuts.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleDto toDto(Role role);

    List<RoleDto> toDto(List<Role> roles);

    Role toEntity(RoleCreateAndUpdateDto roleCreateDto);

}
