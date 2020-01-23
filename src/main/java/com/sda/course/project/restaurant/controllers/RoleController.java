package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.RoleEntity;
import com.sda.course.project.restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public @ResponseBody
    RoleEntity createRole(@RequestBody @Valid RoleEntity newRole) {
        return roleService.addRole(newRole);
    }
}
