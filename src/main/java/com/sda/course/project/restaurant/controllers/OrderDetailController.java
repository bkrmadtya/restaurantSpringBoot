package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.OrderDetailEntity;
import com.sda.course.project.restaurant.service.OrderDetailService;
import com.sda.course.project.restaurant.validation.customExceptions.OrderDetailNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public @ResponseBody
    List<OrderDetailEntity> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    OrderDetailEntity getOrderDetailById(@PathVariable @Min(1) Integer id) {
        return orderDetailService.getOrderDetailById(id).orElseThrow(() -> new OrderDetailNotFound(id));
    }

    @PostMapping
    public @ResponseBody
    OrderDetailEntity addOrderDetail(@RequestBody @Valid OrderDetailEntity newOrderDetailEntity) {
        return orderDetailService.addOrderDetail(newOrderDetailEntity);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    OrderDetailEntity updateOrderDetail(@PathVariable @Min(1) Integer id, @RequestBody @Valid OrderDetailEntity updatedOrderDetail) {
        return orderDetailService.updateOrderDetail(id, updatedOrderDetail);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity deleteOrderDetailById(@PathVariable @Min(1) Integer id) {
        orderDetailService.deleteOrderDetailById(id).orElseThrow(() -> new OrderDetailNotFound(id));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
