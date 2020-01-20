package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Integer> {

}
