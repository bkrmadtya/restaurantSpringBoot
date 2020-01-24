package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.RoleEntity;
import com.sda.course.project.restaurant.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Optional<RoleEntity> getById(Integer id) {
        return roleRepository.findById(id);
    }
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    public RoleEntity addRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public Optional<RoleEntity> deleteRoleById(Integer id) {
        Optional<RoleEntity> roleToDelete = roleRepository.findById(id);

        if (roleToDelete.isPresent()) {
            roleRepository.deleteById(id);
        }
        return roleToDelete;
    }

    public RoleEntity updateRole(Integer id, RoleEntity updatedRole) {
        return roleRepository.findById(id)
                .map(r -> {
                    r.setName(updatedRole.getName());

                    return roleRepository.save(r);
                }).orElseGet(() -> {
                    updatedRole.setId(id);

                    return roleRepository.save(updatedRole);
                });
    }

}
