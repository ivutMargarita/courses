package by.ivuts.service.impl;

import by.ivuts.dto.RoleCreateAndUpdateDto;
import by.ivuts.dto.RoleDto;
import by.ivuts.exception.ServiceException;
import by.ivuts.mapper.RoleMapper;
import by.ivuts.model.Role;
import by.ivuts.repository.RoleRepository;
import by.ivuts.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleDto findById(Long id) {
        try {
            Role role = roleRepository.findById(id);
            return roleMapper.toDto(role);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public List<RoleDto> findAll() {
        try {
            List<Role> roles = roleRepository.findAll();
            return roleMapper.toDto(roles);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void insert(RoleCreateAndUpdateDto dto) {
        try {
            Role role = roleMapper.toEntity(dto);
            roleRepository.insert(role);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    @Override
    public void update(long id, RoleCreateAndUpdateDto dto) {

    }

    public void update(Long id, RoleCreateAndUpdateDto dto) {
        try {
            Role role = roleMapper.toEntity(dto);
            role.setId(id);
            roleRepository.update(role);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            roleRepository.delete(id);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

}
