package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    List<PersonEntity> findByRolesName(String name);

    Optional<PersonEntity> findByFirstName(String name);

    Optional<PersonEntity> findByEmail(String email);

    Optional<PersonEntity> deleteByEmail(String email);
}
