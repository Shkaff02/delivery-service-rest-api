package com.example.delivery.service;

import com.example.delivery.domain.Dish;
import com.example.delivery.domain.Restaurant;
import com.example.delivery.repo.DishRepository;
import com.example.delivery.repo.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        log.info("Saving restaurant {}", restaurant.getName());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant addDishRoRestaurant(Long restaurant_id, Dish dish) {
        log.info("Adding dish {} to the restaurant {}", dish.getName(), restaurant_id);
        Restaurant restaurant = restaurantRepository.findById(restaurant_id).orElse(null);
        restaurant.getDishes().add(dishRepository.save(dish));
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        log.info("Fetching restaurant by id {}", id);
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant getRestaurantByName(String restName) {
        log.info("Fetching restaurant {}", restName);
        return restaurantRepository.findByName(restName);
    }

    @Override
    public List<Restaurant> getAll() {
        log.info("Fetching all restaurants");
        return restaurantRepository.findAll();
    }

    @Override
    public void deleteRestaurant(Long id) {
        log.info("Deleting restaurant {}", id);
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant updateInfo(Restaurant restaurant) {
        log.info("Updating restaurant {} info", restaurant.getName());
        Restaurant updatedRest = restaurantRepository.findById(restaurant.getId()).orElse(null);
        updatedRest.setRating(restaurant.getRating());
        updatedRest.setOrders(restaurant.getOrders());
        updatedRest.setName(restaurant.getName());
        updatedRest.setDishes(restaurant.getDishes());
        updatedRest.setCuisine(restaurant.getCuisine());
        updatedRest.setCouriers(restaurant.getCouriers());
        updatedRest.setAddress(restaurant.getAddress());
        return restaurantRepository.save(updatedRest);
    }
}
