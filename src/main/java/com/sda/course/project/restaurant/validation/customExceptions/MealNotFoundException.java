package com.sda.course.project.restaurant.validation.customExceptions;

public class MealNotFoundException extends RuntimeException {
    public MealNotFoundException(Integer id){
        super("Meal id not found : " + id);
    }
}
