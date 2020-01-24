package com.sda.course.project.restaurant.validation.customExceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Integer id){
        super("Person id not found : " + id);
    }
    public PersonNotFoundException(String email){
        super("Person with email not found : " + email);
    }
}
