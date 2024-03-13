package by.ivuts.repository;

import by.ivuts.model.Role;

import java.util.List;

public interface RoleRepository {

    Role findById(Long id);

    List<Role> findAll();

    void insert(Role role);

    void update(Role role);

    void delete(Long id);

}
