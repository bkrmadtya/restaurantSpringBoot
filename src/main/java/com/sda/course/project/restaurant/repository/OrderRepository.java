package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    // Pagination and sorting for findAll

    List<OrderEntity> findOrdersByPersonId(Integer id);

    List<OrderEntity> findByDate(Date date);

    // handle this with query DSL
    // OR criteria query
    List<OrderEntity> findTop10ByOrderByTotalPriceDesc();
}
