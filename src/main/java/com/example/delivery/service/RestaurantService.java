package com.example.delivery.service;

import com.example.delivery.domain.Dish;
import com.example.delivery.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant addDishRoRestaurant(Long restaurant_id, Dish dish);

    Restaurant getRestaurantById(Long id);

    Restaurant getRestaurantByName(String restName);

    List<Restaurant> getAll();

    void deleteRestaurant(Long id);

    Restaurant updateInfo(Restaurant restaurant);
}
