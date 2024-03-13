package by.ivuts.controller;

import by.ivuts.dto.RoleCreateAndUpdateDto;
import by.ivuts.dto.RoleDto;
import by.ivuts.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping
    public void createRole(@RequestBody RoleCreateAndUpdateDto roleDto) {
        roleService.insert(roleDto);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable Long id, @RequestBody RoleCreateAndUpdateDto roleDto) {
        roleService.update(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
