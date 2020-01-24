package com.sda.course.project.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Setter
@Getter
@ToString
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
    private Integer totalPrice;

    @CreatedDate
    @Column(name = "date_ordered")
    private Date date;
}
