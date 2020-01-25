package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.MealEntity;
import com.sda.course.project.restaurant.service.MealService;
import com.sda.course.project.restaurant.validation.customExceptions.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
//TODO: remove unsed imports
@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public @ResponseBody
    List<MealEntity> getAllMeals(){
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    MealEntity getMealById(@PathVariable @Min(1) Integer id) {
        return mealService.getById(id).orElseThrow(() -> new MealNotFoundException(id));
    }

    @PostMapping
    public @ResponseBody
    MealEntity addMeal(@RequestBody @Valid MealEntity newMeal){
        return mealService.addMeal(newMeal);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    MealEntity updateMeal(@PathVariable @Min(1) Integer id, @RequestBody @Valid MealEntity updatedMeal){
        return mealService.updateMeal(id, updatedMeal);
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable @Min(1) Integer id){
        mealService.deleteMealById(id);
    }


}
