package com.example.delivery.controller;

import com.example.delivery.domain.Dish;
import com.example.delivery.domain.Restaurant;
import com.example.delivery.dto.RestaurantDTO;
import com.example.delivery.mappers.RestaurantMapper;
import com.example.delivery.service.RestaurantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        return ResponseEntity.ok().body(RestaurantMapper.INSTANCE
                .RestaurantsToRestaurantsDTO(restaurantService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok().body(RestaurantMapper.INSTANCE.toDTO(restaurantService.getRestaurantById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestaurantDTO> getRestaurantByName(@PathVariable String name) {
        return ResponseEntity.ok().body(RestaurantMapper.INSTANCE.toDTO(restaurantService.getRestaurantByName(name)));
    }

    @PostMapping
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok().body(restaurantService.saveRestaurant(restaurant));
    }

    @PutMapping("/{id}/dish")
    public ResponseEntity<Restaurant> addDishToRestaurant(@PathVariable Long id, @RequestBody Dish dish) {

        return ResponseEntity.ok().body(restaurantService.addDishRoRestaurant(id, dish));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Restaurant> updateRestInfo(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok().body(restaurantService.updateInfo(restaurant));
    }
}
