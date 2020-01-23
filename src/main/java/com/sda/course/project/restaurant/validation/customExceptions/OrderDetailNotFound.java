package com.sda.course.project.restaurant.validation.customExceptions;

public class OrderDetailNotFound extends RuntimeException {
    public OrderDetailNotFound(Integer id){
        super("Order detail id not found : " + id);
    }
}
