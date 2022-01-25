package com.example.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;

    private Date date;

    private String destination;

    private String status;

    @ManyToMany
    @JoinTable(name = "orders_dishes",
                joinColumns = {@JoinColumn(name = "ord_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private Set<Dish> dishes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "rest_id", referencedColumnName = "id")
    private Restaurant restaurant;

}
