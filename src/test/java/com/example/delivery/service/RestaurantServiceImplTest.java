package com.example.delivery.service;

import com.example.delivery.domain.Restaurant;
import com.example.delivery.repo.DishRepository;
import com.example.delivery.repo.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceImplTest {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private DishRepository dishRepository;

    @BeforeEach
    void setUp() {
        restaurantService = new RestaurantServiceImpl(restaurantRepository, dishRepository);
    }

    @Test
    public void saveRestaurantTest() {
        Restaurant restaurant = new Restaurant();
        restaurantService.saveRestaurant(restaurant);

        Mockito.verify(restaurantRepository).save(restaurant);
    }

    @Test
    public void getRestaurantByIdTest() {
        Long id = 1L;
        restaurantService.getRestaurantById(id);

        Mockito.verify(restaurantRepository).findById(id);
    }

    @Test
    public void getRestaurantByNameTest() {
        String name = "Chin-chin";
        restaurantService.getRestaurantByName(name);

        Mockito.verify(restaurantRepository).findByName(name);
    }

    @Test
    public void getAllTest() {
        restaurantService.getAll();

        Mockito.verify(restaurantRepository).findAll();
    }

    @Test
    public void deleteRestaurantTest() {
        Long id = 1L;
        restaurantService.deleteRestaurant(id);

        Mockito.verify(restaurantRepository).deleteById(id);
    }


}
