package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.MealEntity;
import com.sda.course.project.restaurant.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<MealEntity> getAllMeals() {
        return mealRepository.findAll();
    }

    public MealEntity getById(Integer id) {
        return mealRepository.findById(id).orElse(null);
    }

    public void addMeal(MealEntity meal) {
        mealRepository.save(meal);
    }

    public void deleteMealById(Integer id) {
        mealRepository.deleteById(id);
    }

    public void updateMeal(MealEntity updatedMeal){
        mealRepository.save(updatedMeal);
    }


}
