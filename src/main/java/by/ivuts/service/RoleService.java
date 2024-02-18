package by.ivuts.service;

import by.ivuts.dto.RoleCreateAndUpdateDto;
import by.ivuts.dto.RoleDto;
import by.ivuts.mapper.RoleMapper;
import by.ivuts.model.Role;
import by.ivuts.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id);
        return roleMapper.toDto(role);
    }

    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toDto(roles);
    }

    public void insert(RoleCreateAndUpdateDto dto) {
        Role role = roleMapper.toEntity(dto);
        roleRepository.insert(role);
    }

    public void update(RoleCreateAndUpdateDto dto) {
        Role role = roleMapper.toEntity(dto);
        roleRepository.update(role);
    }

    public void delete(Long id) {
        roleRepository.delete(id);
    }

}
