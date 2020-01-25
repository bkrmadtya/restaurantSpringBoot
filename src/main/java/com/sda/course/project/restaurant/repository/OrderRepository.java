package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
//TODO: remove unused imports
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    // Pagination and sorting for findAll
//TODO: when we want to do something in feature we use TODO: at the start of the line
    List<OrderEntity> findOrdersByPersonId(Integer id);

    List<OrderEntity> findByDate(Date date);

    // handle this with query DSL
    // OR criteria query
    List<OrderEntity> findTop10ByOrderByTotalPriceDesc();
}
