package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.PersonEntity;
import com.sda.course.project.restaurant.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonEntity createPerson(PersonEntity newPerson) {
        return personRepository.save(newPerson);
    }

    public List<PersonEntity> getAllPeople() {
        return personRepository.findAll();
    }

    public PersonEntity getByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }

    public PersonEntity getByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    // return optional of PersonEntity
    public PersonEntity getById(Integer id) {
        System.out.println(id);
        return personRepository.findById(id).orElse(null);
    }

    public List<PersonEntity> getByRole(String role) {
        return personRepository.findByRolesName(role);
    }

    public PersonEntity updatePersonPartially(Integer id, PersonEntity newPerson) {
        return personRepository
                .findById(id)
                .map(person -> {
                    BeanUtils.copyProperties(newPerson, person);
                    return personRepository.save(person);
                }).orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    public void deletePersonByEmail(String email) {
        System.out.println(email);
        PersonEntity personToDelete = personRepository.findByEmail(email);

        System.out.println(personToDelete);
        personRepository.delete(personToDelete);
    }
}
