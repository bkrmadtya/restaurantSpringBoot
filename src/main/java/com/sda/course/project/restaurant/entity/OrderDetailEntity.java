package com.sda.course.project.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "order_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private MealEntity meal;

    @Min(1)
    @Column
    private Integer quantity;

    @Min(5)
    @Column
    private Integer price;
}
