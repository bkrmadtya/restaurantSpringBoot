package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.PersonEntity;
import com.sda.course.project.restaurant.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity addPerson(PersonEntity newPerson) {
        return personRepository.save(newPerson);
    }

    public List<PersonEntity> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> getByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }

    public Optional<PersonEntity> getByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Optional<PersonEntity> getById(Integer id) {
        return personRepository.findById(id);
    }

    public List<PersonEntity> getByRole(String role) {
        return personRepository.findByRolesName(role);
    }

    public List<PersonEntity> getTopTenCustomer(){
        QPersonEntity person = QPersonEntity.person;
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

    public Optional<PersonEntity> updatePersonPartially(Integer id, PersonEntity partialPerson) {
        return personRepository.findById(id)
                .map( p -> {
                    if (partialPerson.getFirstName() != null) {
                        p.setFirstName(partialPerson.getFirstName());
                    } else if (partialPerson.getLastName() != null) {
                        p.setLastName(partialPerson.getLastName());
                    } else if (partialPerson.getPhone() > 7) {
                        p.setPhone(partialPerson.getPhone());
                    } else if (partialPerson.getEmail() != null) {
                        p.setEmail(partialPerson.getEmail());
                    } else if (partialPerson.getRoles() != null) {
                        p.setRoles(partialPerson.getRoles());
                    }
                    return personRepository.save(p);
                });

//        updates.forEach((k, v) -> {
//            Field field = ReflectionUtils.findRequiredField(PersonEntity.class, k);
//            ReflectionUtils.setField(field, personToUpdate, v);
//        });

    }

    public Optional<PersonEntity> deletePersonById(Integer id) {
        Optional<PersonEntity> personToDelete = personRepository.findById(id);

        if(personToDelete.isPresent()){
            personRepository.deleteById(id);
        }

        return personToDelete;
    }

    public Optional<PersonEntity> deletePersonByEmail(String email) {
        Optional<PersonEntity> personToDelete = personRepository.findByEmail(email);

        if(personToDelete.isPresent()){
            personRepository.deleteByEmail(email);
        }

        return personToDelete;
    }
}
