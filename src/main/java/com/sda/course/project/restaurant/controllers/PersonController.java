package com.sda.course.project.restaurant.controllers;


import com.sda.course.project.restaurant.entity.PersonEntity;
import com.sda.course.project.restaurant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public @ResponseBody
    List<PersonEntity> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    PersonEntity getPersonById(@PathVariable @Min(1) Integer id) {
        return personService.getById(id);
    }

    @GetMapping(value = "/email/{email}")
    public @ResponseBody
    PersonEntity getPersonByEmail(@PathVariable String email) {
        return personService.getByEmail(email);
    }

    @GetMapping(value = "/customers")
    public @ResponseBody
    List<PersonEntity> getCustomers() {
        return personService.getByRole("Customer");
    }

    @GetMapping(value = "/employees")
    public @ResponseBody
    List<PersonEntity> getEmployees() {
        return personService.getByRole("Employee");
    }

    @GetMapping(value = "/customers/{customerId}")
    public @ResponseBody
    PersonEntity getCustomerDetails(@PathVariable @Min(1) Integer customerId) {
        return personService.getById(customerId);
    }

    @PostMapping
    public @ResponseBody
    PersonEntity createPerson(@Valid @RequestBody PersonEntity newPerson) {
        return personService.createPerson(newPerson);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    PersonEntity updatePerson(@PathVariable @Min(1) Integer id, @RequestBody @Valid PersonEntity updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
    }

    @PatchMapping(value = "/{id}")
    public @ResponseBody
    PersonEntity updatePersonPartially(@PathVariable @Min(1) Integer id, @RequestBody PersonEntity updatedPerson) {
        return personService.updatePersonPartially(id, updatedPerson);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePersonById(@PathVariable @Min(1) Integer id) {
        personService.deletePersonById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public void deletePersonByEmail(@RequestParam String email) {
        personService.deletePersonByEmail(email);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    String handleConstraintViolationException(ConstraintViolationException e){
        return "Not valid due to validation error: " + e.getMessage();
    }
}
