package com.sda.course.project.restaurant.validation.customExceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id){
        super("Person id not found : " + id);
    }
}
