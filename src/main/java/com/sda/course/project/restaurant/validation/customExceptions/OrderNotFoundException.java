package com.sda.course.project.restaurant.validation.customExceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super("Order id not found : " + id);
    }
}
