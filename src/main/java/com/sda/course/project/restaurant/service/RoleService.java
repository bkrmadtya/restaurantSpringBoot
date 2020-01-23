package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.RoleEntity;
import com.sda.course.project.restaurant.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity getById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    public RoleEntity addRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }

    public RoleEntity updateRole(RoleEntity updatedRole) {
        return roleRepository.save(updatedRole);
    }

}
