package by.ivuts.mapper;

import by.ivuts.dto.UserCreateAndUpdateDto;
import by.ivuts.dto.UserDto;
import by.ivuts.model.Role;
import by.ivuts.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    @Mapping(source = "roleIds", target = "roles", qualifiedByName = "roleIdsToRoles")
    User toEntity(UserCreateAndUpdateDto userCreateAndUpdateDto);

    @Named("roleIdsToRoles")
    default Set<Role> roleIdsToRoles(List<Long> roleIds) {
        return roleIds.stream()
                .map(id -> new Role(id))
                .collect(Collectors.toSet());
    }

}
