package com.example.delivery.service;

import com.example.delivery.domain.Dish;
import com.example.delivery.domain.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order, Long[] dishes, Long cour_id, Long rest_id );

    Order addDishesToOrder(Long id, Long dish);

    Order getOrderById(Long id);

    Order updateOrderInfo(Order order);

    List<Order> getAll();

    void deleteOrder(Long id);

}
