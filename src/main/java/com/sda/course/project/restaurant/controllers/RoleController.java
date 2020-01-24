package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.RoleEntity;
import com.sda.course.project.restaurant.service.RoleService;
import com.sda.course.project.restaurant.validation.customExceptions.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public @ResponseBody
    List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    RoleEntity getRoleById(@PathVariable @Min(1) Integer id) {
        return roleService.getById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }

    @PostMapping
    public @ResponseBody
    RoleEntity createRole(@RequestBody @Valid RoleEntity newRole) {
        return roleService.addRole(newRole);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    RoleEntity updateRole(@PathVariable @Min(1) Integer id, @RequestBody @Valid RoleEntity updatedRole) {
        return roleService.updateRole(id, updatedRole);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    RoleEntity deleteRole(@PathVariable @Min(1) Integer id) {
        return roleService.deleteRoleById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }
}
