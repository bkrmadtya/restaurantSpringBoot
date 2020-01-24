package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.MealEntity;
import com.sda.course.project.restaurant.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<MealEntity> getAllMeals() {
        return mealRepository.findAll();
    }

    public Optional<MealEntity> getById(Integer id) {
        return mealRepository.findById(id);
    }

    public MealEntity addMeal(MealEntity meal) {
        return mealRepository.save(meal);
    }

    public Optional<MealEntity> deleteMealById(Integer id) {
        Optional<MealEntity> mealToDelete = mealRepository.findById(id);

        if(mealToDelete.isPresent()){
            mealRepository.deleteById(id);
        }
        return mealToDelete;
    }

    public MealEntity updateMeal(Integer id, MealEntity updatedMeal){
        return mealRepository.findById(id).map( m -> {
            m.setName(updatedMeal.getName());
            m.setUnitPrice(updatedMeal.getUnitPrice());

            return mealRepository.save(m);
        }).orElseGet(() -> {
            updatedMeal.setId(id);
            return mealRepository.save(updatedMeal);
        });
    }


}
