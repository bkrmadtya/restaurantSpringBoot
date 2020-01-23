package com.sda.course.project.restaurant.validation.customExceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException (Long id){
        super("Role id not found : " + id);
    }
}
