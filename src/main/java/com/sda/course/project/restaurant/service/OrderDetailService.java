package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.OrderDetailEntity;
import com.sda.course.project.restaurant.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetailEntity> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetailEntity> getOrderDetailById(Integer id) {
        return orderDetailRepository.findById(id);
    }

    public OrderDetailEntity addOrderDetail(OrderDetailEntity orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public Optional<OrderDetailEntity> deleteOrderDetailById(Integer id) {
        Optional<OrderDetailEntity> orderDetailToDelete = orderDetailRepository.findById(id);

        if(orderDetailToDelete.isPresent()){
            orderDetailRepository.deleteById(id);
        }

        return orderDetailToDelete;
    }

    public OrderDetailEntity updateOrderDetail(Integer id, OrderDetailEntity updatedOrderDetail) {
        return orderDetailRepository.findById(id)
                .map(od -> {
                    od.setMeal(updatedOrderDetail.getMeal());
                    od.setOrder(updatedOrderDetail.getOrder());
                    od.setPrice(updatedOrderDetail.getPrice());
                    od.setQuantity(updatedOrderDetail.getQuantity());

                    return orderDetailRepository.save(od);
                }).orElseGet(() -> {
                    updatedOrderDetail.setId(id);
                    return orderDetailRepository.save(updatedOrderDetail);
                });
    }

}
