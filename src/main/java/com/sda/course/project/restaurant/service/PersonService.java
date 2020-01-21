package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.PersonEntity;
import com.sda.course.project.restaurant.repository.PersonRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        return personRepository.findById(id).orElse(null);
    }

    public List<PersonEntity> getByRole(String role) {
        return personRepository.findByRolesName(role);
    }

    public PersonEntity updatePerson(Integer id, PersonEntity updatedPerson) {

        return personRepository.findById(id).map(
                p -> {
                    p.setFirstName(updatedPerson.getFirstName());
                    p.setLastName(updatedPerson.getLastName());
                    p.setEmail(updatedPerson.getEmail());
                    p.setPhone(updatedPerson.getPhone());
                    p.setRoles(updatedPerson.getRoles());

                    return personRepository.save(p);
                }
        ).orElseGet(() -> {
            updatedPerson.setId(id);
            return personRepository.save(updatedPerson);
        });
    }

    public PersonEntity updatePersonPartially(Integer id, Map<String, Object> updates) {
        PersonEntity personToUpdate = personRepository.findById(id).orElse(null);

        updates.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(PersonEntity.class, k);
            ReflectionUtils.setField(field, personToUpdate, v);
        });

        return personRepository.save(personToUpdate);
    }

    public void deletePersonById(Integer id) {
        PersonEntity personToDelete = personRepository.findById(id).orElse(null);
        personRepository.deleteById(id);
    }

    public void deletePersonByEmail(String email) {
        System.out.println(email);
        PersonEntity personToDelete = personRepository.findByEmail(email);

        System.out.println(personToDelete);
        personRepository.delete(personToDelete);
    }
}
