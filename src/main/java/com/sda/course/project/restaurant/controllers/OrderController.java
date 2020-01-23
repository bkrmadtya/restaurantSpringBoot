package com.sda.course.project.restaurant.controllers;


import com.sda.course.project.restaurant.entity.OrderEntity;
import com.sda.course.project.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public @ResponseBody
    List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/person/{personId}")
    List<OrderEntity> getAllOrdersByPerson(@PathVariable Integer personId) {
        return orderService.getOrdersByPerson(personId);
    }

    @GetMapping(value = "/today")
    List<OrderEntity> getAllTodayOrders() {
        return orderService.getAllTodayOrders();
    }

    @GetMapping(value = "/highest")
    List<OrderEntity> getHighestOrders() {
        return orderService.getTopTenUsersByOrder();
    }

    // custom exceptions with exception handlers from Spring
    @PostMapping
    public @ResponseBody
    OrderEntity placeOrder(@RequestBody @Valid OrderEntity newOrder) {
        return orderService.addOrder(newOrder);
    }

}
