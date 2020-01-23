package com.sda.course.project.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;


    @Min(5)
    @Column(name = "total_price")
    private int totalPrice;

    @NotNull
    @CreatedDate
    @Column(name = "date_ordered")
    private Date date;
}
