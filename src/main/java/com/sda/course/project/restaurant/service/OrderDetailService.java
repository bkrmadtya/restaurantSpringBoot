package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.OrderDetailEntity;
import com.sda.course.project.restaurant.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetailEntity> getAllOrderMeals() {
        return orderDetailRepository.findAll();
    }

    public OrderDetailEntity getOrderMealById(Integer id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    public void addOrderMeal(OrderDetailEntity orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderMealById(Integer id) {
        orderDetailRepository.deleteById(id);
    }

    public void updateOrderMeal(OrderDetailEntity updatedOrderDetail) {
        orderDetailRepository.save(updatedOrderDetail);
    }

}
