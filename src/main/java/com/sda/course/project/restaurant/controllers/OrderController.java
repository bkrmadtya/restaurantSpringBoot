package com.sda.course.project.restaurant.controllers;


import com.sda.course.project.restaurant.entity.OrderEntity;
import com.sda.course.project.restaurant.service.OrderService;
import com.sda.course.project.restaurant.validation.customExceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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

    @GetMapping("/{id}")
    public @ResponseBody
    OrderEntity getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @GetMapping(value = "/person/{personId}")
    List<OrderEntity> getAllOrdersByPerson(@PathVariable @Min(1) Integer personId) {
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

    @DeleteMapping("/{id}")
    public @ResponseBody
    OrderEntity deleteOrder(@PathVariable @Min(1) Integer id) {
        return orderService.deleteOrderById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

}
