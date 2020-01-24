package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.OrderEntity;
import com.sda.course.project.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Integer id) {
        return orderRepository.findById(id);
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

    public OrderEntity addOrder(OrderEntity newOrder) {
        newOrder.setDate(new Date());
        return orderRepository.save(newOrder);
    }

    public Optional<OrderEntity> deleteOrderById(Integer id) {
        Optional<OrderEntity> orderToDelete = orderRepository.findById(id);

        if (orderToDelete.isPresent()) {
            orderRepository.deleteById(id);
        }

        return orderToDelete;
    }

    public OrderEntity updateOrder(Integer id, OrderEntity updatedOrder) {
        return orderRepository.findById(id)
                .map(o -> {
                    o.setDate(updatedOrder.getDate());
                    o.setPerson(updatedOrder.getPerson());
                    o.setTotalPrice(updatedOrder.getTotalPrice());

                    return orderRepository.save(o);
                }).orElseGet(() -> {
                    updatedOrder.setOrderId(id);
                    return orderRepository.save(updatedOrder);
                });
    }
}
