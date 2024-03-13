package by.ivuts.service;

import by.ivuts.dto.RoleCreateAndUpdateDto;
import by.ivuts.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto findById(Long id);

    List<RoleDto> findAll();

    void insert(RoleCreateAndUpdateDto dto);

    void update(long id, RoleCreateAndUpdateDto dto);

    void delete(Long id);

}
