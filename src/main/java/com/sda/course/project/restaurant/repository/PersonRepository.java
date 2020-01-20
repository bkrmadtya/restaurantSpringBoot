package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    List<PersonEntity> findByRolesName(String name);

    PersonEntity findByFirstName(String name);

    PersonEntity findByEmail(String email);

}
