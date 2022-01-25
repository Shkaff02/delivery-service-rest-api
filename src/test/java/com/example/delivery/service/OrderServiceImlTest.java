package com.example.delivery.service;

import com.example.delivery.domain.Order;
import com.example.delivery.repo.CourierRepository;
import com.example.delivery.repo.DishRepository;
import com.example.delivery.repo.OrderRepository;
import com.example.delivery.repo.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImlTest {
    @Autowired
    OrderServiceImpl orderService;

    @Mock
    private OrderRepository repository;

    @Mock
    private DishRepository dishRepository;

    @Mock
    private CourierRepository courierRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(repository, dishRepository, courierRepository, restaurantRepository);
    }

    @Test
    public void saveOrderTest() {
        Order order = new com.example.delivery.domain.Order();
        Long cour_id = 1L;
        Long rest_id = 1L;

        orderService.saveOrder(order, new Long[]{1L,2L,3L}, cour_id, rest_id);

        Mockito.verify(repository).save(order);
        Mockito.verify(courierRepository).findById(cour_id);
        Mockito.verify(restaurantRepository).findById(rest_id);
    }

    @Test
    public void getOrderByIdTest() {
        Long id = 1L;

        orderService.getOrderById(id);

        Mockito.verify(repository).findById(id);
    }

    @Test
    public void getAllTest() {
        orderService.getAll();

        Mockito.verify(repository).findAll();
    }

    @Test
    public void deleteOrderTest() {
        Long id = 1L;

        orderService.deleteOrder(id);

        Mockito.verify(repository).deleteById(id);
    }

}
