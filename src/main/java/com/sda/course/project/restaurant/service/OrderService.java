package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.OrderEntity;
import com.sda.course.project.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<OrderEntity> getOrdersByPerson(Integer id) {
        return orderRepository.findOrdersByPersonId(id);
    }

    public List<OrderEntity> getAllTodayOrders() {
        return orderRepository.findByDate(new Date());
    }

    public List<OrderEntity> getTopTenUsersByOrder() {
        return orderRepository.findTop10ByOrderByTotalPriceDesc();
//        orderRepository.findAll();

    }

    public OrderEntity addOrder(@NotNull OrderEntity order) {
        order.setDate(new Date());
        return orderRepository.save(order);
    }

    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }

    public void updateOrder(OrderEntity updatedOrder) {
        orderRepository.save(updatedOrder);
    }
}
