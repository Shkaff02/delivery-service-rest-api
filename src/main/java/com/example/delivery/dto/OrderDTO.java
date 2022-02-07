package com.example.delivery.dto;

import com.example.delivery.domain.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int price;

    private Date date;

    private String destination;

    private String status;

    private Set<Dish> dishes = new HashSet<>();
}
