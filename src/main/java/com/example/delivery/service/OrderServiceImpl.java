package com.example.delivery.service;

import com.example.delivery.domain.Dish;
import com.example.delivery.domain.Order;
import com.example.delivery.repo.CourierRepository;
import com.example.delivery.repo.DishRepository;
import com.example.delivery.repo.OrderRepository;
import com.example.delivery.repo.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service @Slf4j @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final CourierRepository courierRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Order saveOrder(Order order, Long[] dishes, Long cour_id, Long rest_id) {
        log.info("Saving order {}", order.getId());
        stream(dishes).forEach(dish -> order.getDishes().add(dishRepository.findById(dish).orElse(null)));
        order.setCourier(courierRepository.findById(cour_id).orElse(null));
        order.setRestaurant(restaurantRepository.findById(rest_id).orElse(null));
        return orderRepository.save(order);
    }

    @Override
    public Order addDishesToOrder(Long ord_id, Long dish_id) {
        log.info("Adding dish {} to order {}", dish_id, ord_id);
        Order order = orderRepository.findById(ord_id).orElse(null);
        Dish dish = dishRepository.findById(dish_id).orElse(null);
        order.getDishes().add(dish);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        log.info("Fetching order by id {}", id);
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrderInfo(Order order) {
        log.info("Updating order {}", order.getId());
        Order updatedOrder = orderRepository.findById(order.getId()).orElse(null);
        updatedOrder.setStatus(order.getStatus());
        updatedOrder.setRestaurant(order.getRestaurant());
        updatedOrder.setPrice(order.getPrice());
        updatedOrder.setCourier(order.getCourier());
        updatedOrder.setDishes(order.getDishes());
        updatedOrder.setDate(order.getDate());
        updatedOrder.setDestination(order.getDestination());

        return orderRepository.save(updatedOrder);
    }

    @Override
    public List<Order> getAll() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        log.info("Deleting order {}", id);
        orderRepository.deleteById(id);
    }
}
